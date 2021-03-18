package webprj.board.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import webprj.board.PageObject;
import webprj.board.service.board.BoardService;
import webprj.board.service.file.FileService;
import webprj.board.util.MD5Generator;
import webprj.board.vo.BoardVO;
import webprj.board.vo.FileVO;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {

  private final String MODULE = "board";

  @Autowired
  @Qualifier("boardServiceImpl")
  private BoardService boardService;

  @Autowired
  @Qualifier("fileServiceImpl")
  private FileService fileService;

  @GetMapping("/list")
  public String list(PageObject pageObject, Model model){
    model.addAttribute("list", boardService.list(pageObject));
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
      boardService.write(bvo);

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
        fileService.saveFile(fvo);
      }
    } catch (NoSuchAlgorithmException | IOException e) {
      e.printStackTrace();
    }

    return "redirect:list";
  }

  @GetMapping("/content_view")
  public String content_view(int bId, Model model){
    model.addAttribute("content", boardService.view(bId));
    model.addAttribute("file", fileService.getFileWithBID(bId));
    return MODULE + "/content_view";
  }

  @ResponseBody
  @GetMapping("/fileDown")
  public ResponseEntity<Resource> fileDownload(int fId) throws IOException {
    FileVO fvo = fileService.getFileWithFID(fId);
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
      model.addAttribute("content", boardService.view(bId));
      return MODULE + "/modify_view";
  }

  @PostMapping("/modify")
  public String modify(BoardVO bvo){
    boardService.modify(bvo);
    return "redirect:list";
  }

  @GetMapping("/delete")
  public String delete(int bId){
    boardService.delete(bId);
    return "redirect:list";
  }
}
