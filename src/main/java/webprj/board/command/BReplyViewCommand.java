package webprj.board.command;

import org.springframework.ui.Model;
import webprj.board.dao.BDao;
import webprj.board.dto.BDto;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BReplyViewCommand implements webprj.board.command.BCommand {
  @Override
  public void execute(Model model) {
    Map<String, Object> map = model.asMap();
    HttpServletRequest request = (HttpServletRequest) map.get("request");
    int bId = Integer.parseInt(request.getParameter("bId"));

    BDao dao = new BDao();
    BDto dto = dao.reply_view(bId);
    model.addAttribute("reply", dto);
  }
}
