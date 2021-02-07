package webprj.board.command;

import org.springframework.ui.Model;
import webprj.board.dao.BDao;
import webprj.board.dto.BDto;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BContentCommand implements webprj.board.command.BCommand {
  @Override
  public void execute(Model model) {
//    Map<String, Object> map = model.asMap();
//    HttpServletRequest request = (HttpServletRequest) map.get("request");
//    int bId = Integer.parseInt(request.getParameter("bId"));
    int bId = (Integer) model.getAttribute("bId");
    BDao dao = new BDao();
    BDto dto = dao.contentView(bId);

    model.addAttribute("content",dto);
  }
}
