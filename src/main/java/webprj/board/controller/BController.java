package webprj.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webprj.board.PageObject;
import webprj.board.service.BService;
import webprj.board.vo.BVO;

@Controller
@RequestMapping("/board")
public class BController {

  private final String MODULE = "board";

  @Autowired
  @Qualifier("bServiceImpl")
  private BService service;

  @GetMapping("/list")
  public String list(PageObject pageObject, Model model){
    model.addAttribute("list", service.list(pageObject));
    model.addAttribute("pageObject", pageObject);

    return MODULE + "/list";
  }

  @GetMapping("/write_view")
  public String write_view(){
    return MODULE + "/write_view";
  }

  @PostMapping("/write")
  public String write(BVO bvo){
    service.write(bvo);
    return "redirect:list";
  }

  @GetMapping("/content_view")
  public String content_view(int bId, Model model){
    model.addAttribute("content", service.view(bId));
    return MODULE + "/content_view";
  }

  @GetMapping("/modify_view")
  public String modify_view(int bId, Model model){
      model.addAttribute("content", service.view(bId));
      return MODULE + "/modify_view";
  }

  @PostMapping("/modify")
  public String modify(BVO bvo){
    service.modify(bvo);
    return "redirect:list";
  }

  @GetMapping("/delete")
  public String delete(int bId){
    service.delete(bId);
    return "redirect:list";
  }
}
