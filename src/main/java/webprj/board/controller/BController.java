package webprj.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import webprj.board.command.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board")
public class BController {
  BCommand command;

  @RequestMapping("/list")
  public String list(Model model){
    command = new BListCommand();
    command.execute(model);
    return "board/list";
  }

  @RequestMapping("/write_view")
  public String write_view(Model model){

    return "board/write_view";
  }

  @RequestMapping("/write")
  public String write(HttpServletRequest request, Model model){
    model.addAttribute("request", request);
    command = new BWriteCommand();
    command.execute(model);
    return "redirect:list";
  }

  @RequestMapping("/content_view")
  public String content_view(HttpServletRequest request, Model model){
    model.addAttribute("request", request);
    command = new BContentCommand();
    command.execute(model);
    return "board/content_view";
  }

  @RequestMapping(method = RequestMethod.POST, value = "/modify")
  public String modify(HttpServletRequest request, Model model){
    model.addAttribute("request", request);
    command = new BModifyCommand();
    command.execute(model);
    return "redirect:list";
  }

  @RequestMapping("/reply_view")
  public String reply_view(HttpServletRequest request, Model model){
    model.addAttribute("request", request);
    command = new BReplyViewCommand();
    command.execute(model);
    return "board/reply_view";
  }

  @RequestMapping("/reply")
  public String reply(HttpServletRequest request, Model model){
    model.addAttribute("request", request);
    command = new BReplyCommand();
    command.execute(model);
    return "redirect:list";
  }

  @RequestMapping("/delete")
  public String delete(HttpServletRequest request, Model model){
    model.addAttribute("request", request);
    command = new BDeleteCommand();
    command.execute(model);
    return "redirect:list";
  }


}
