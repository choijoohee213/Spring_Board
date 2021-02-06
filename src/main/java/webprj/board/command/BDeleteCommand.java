package webprj.board.command;

import org.springframework.ui.Model;
import webprj.board.dao.BDao;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BDeleteCommand implements webprj.board.command.BCommand {
  @Override
  public void execute(Model model) {
    Map<String,Object> map = model.asMap();
    HttpServletRequest request = (HttpServletRequest) map.get("request");
    int bId = Integer.parseInt(request.getParameter("bId"));

    BDao dao = new BDao();
    dao.delete(bId);
  }
}
