package webprj.board.command;

import org.springframework.ui.Model;
import webprj.board.dao.BDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Map;

public class BModifyCommand implements webprj.board.command.BCommand {
  @Override
  public void execute(Model model) {
    Map<String, Object> map = model.asMap();
    HttpServletRequest request = (HttpServletRequest) map.get("request");
    int bId = Integer.parseInt(request.getParameter("bId"));
    String bName = request.getParameter("bName");
    String bTitle = request.getParameter("bTitle");
    String bContent = request.getParameter("bContent");

    BDao dao = new BDao();
    dao.modify(bId, bName, bTitle, bContent);
  }
}
