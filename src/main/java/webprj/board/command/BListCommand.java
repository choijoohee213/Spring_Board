package webprj.board.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import webprj.board.dao.BDao;
import webprj.board.dto.BDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class BListCommand implements webprj.board.command.BCommand {

  @Override
  public void execute(Model model) {
    BDao dao = new BDao();
    ArrayList<BDto> dtos = dao.list();
    model.addAttribute("list", dtos);
  }
}
