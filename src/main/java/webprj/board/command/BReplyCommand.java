package webprj.board.command;

import org.springframework.ui.Model;
import webprj.board.dao.BDao;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BReplyCommand implements webprj.board.command.BCommand {
  @Override
  public void execute(Model model) {
    Map<String, Object> map = model.asMap();
    HttpServletRequest request = (HttpServletRequest) map.get("request");

    String bName = request.getParameter("bName");
    String bTitle = request.getParameter("bTitle");
    String bContent = request.getParameter("bContent");
    int bGroup = Integer.parseInt(request.getParameter("bGroup"));
    int bStep = Integer.parseInt(request.getParameter("bStep"));
    int bIndent = Integer.parseInt(request.getParameter("bIndent"));

    BDao dao = new BDao();
    dao.reply(bName, bTitle, bContent, bGroup, bStep, bIndent);
  }
}
