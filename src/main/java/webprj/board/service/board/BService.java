package webprj.board.service.board;

import webprj.board.PageObject;
import webprj.board.vo.BoardVO;

import java.util.List;

public interface BService {
  //1.list
  List<BoardVO> list(PageObject pageObject);

  //2.view
  BoardVO view(int bId);

  //3.write
  void write(BoardVO bvo);

  //4.modify
  void modify(BoardVO bvo);

  //5.delete
  void delete(int bId);
}
