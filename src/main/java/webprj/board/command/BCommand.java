package webprj.board.command;

import org.springframework.ui.Model;

import java.sql.SQLException;

public interface BCommand {
  void execute(Model model);
}
