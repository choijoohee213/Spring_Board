package webprj.board.controller;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import webprj.board.PageObject;
import webprj.board.service.board.BService;
import webprj.board.service.file.FService;
import webprj.board.util.MD5Generator;
import webprj.board.vo.BoardVO;
import webprj.board.vo.FileVO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

@Controller
@Log4j2
@RequestMapping("/board")
public class BController {

  private final String MODULE = "board";

  @Autowired
  @Qualifier("bServiceImpl")
  private BService bService;

  @Autowired
  @Qualifier("fServiceImpl")
  private FService fService;

  @GetMapping("/list")
  public String list(PageObject pageObject, Model model){
    model.addAttribute("list", bService.list(pageObject));
    model.addAttribute("pageObject", pageObject);

    return MODULE + "/list";
  }

  @GetMapping("/write_view")
  public String write_view(){
    return MODULE + "/write_view";
  }

  @PostMapping("/write")
  public String write( BoardVO bvo, MultipartFile file){
    try {
      bService.write(bvo);

      if(!file.isEmpty()) {
        String path = System.getProperty("user.dir") + "\\files";
        String origFileName = file.getOriginalFilename();
        String fileType = origFileName.substring(origFileName.lastIndexOf(".") + 1);
        String fileName = new MD5Generator(origFileName).toString() + fileType;

        /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
        if (!new File(path).exists()) {
          try{
            new File(path).mkdir();
          }
          catch(Exception e){
            e.getStackTrace();
          }
        }
        String filePath = path + "\\" + fileName;
        file.transferTo(new File(filePath));

        FileVO fvo = new FileVO();
        fvo.setBId(bvo.getBId());
        fvo.setFOrgi_name(origFileName);
        fvo.setFName(fileName);
        fvo.setFPath(filePath);
        fService.saveFile(fvo);
      }
    } catch (NoSuchAlgorithmException | IOException e) {
      e.printStackTrace();
    }

    return "redirect:list";
  }

  @GetMapping("/content_view")
  public String content_view(int bId, Model model){
    model.addAttribute("content", bService.view(bId));
    model.addAttribute("file", fService.getFileWithBID(bId));
    return MODULE + "/content_view";
  }

  @ResponseBody
  @GetMapping("/fileDown")
  public ResponseEntity<Resource> fileDownload(int fId) throws IOException {
    FileVO fvo = fService.getFileWithFID(fId);
    Path path = Paths.get(fvo.getFPath());
    Resource resource = new InputStreamResource(Files.newInputStream(path));
    String fileName = URLEncoder.encode(fvo.getFOrgi_name(),"UTF-8")
          .replaceAll("\\+", "%20")
          .replaceAll("%2B", "+")
          .replaceAll("%28", "(")
          .replaceAll("%29", ")")
          .replaceAll("%40", "@");

    return ResponseEntity.ok()
          .contentType(MediaType.parseMediaType("application/octet-stream"))
          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + fileName + "\";")
          .body(resource);
  }

  @GetMapping("/modify_view")
  public String modify_view(int bId, Model model){
      model.addAttribute("content", bService.view(bId));
      return MODULE + "/modify_view";
  }

  @PostMapping("/modify")
  public String modify(BoardVO bvo){
    bService.modify(bvo);
    return "redirect:list";
  }

  @GetMapping("/delete")
  public String delete(int bId){
    bService.delete(bId);
    return "redirect:list";
  }
}
