package webprj.board.service;

import webprj.board.PageObject;
import webprj.board.vo.BVO;

import java.util.List;

public interface BService {
  //1.list
  List<BVO> list(PageObject pageObject);

  //2.view
  BVO view(int bId);

  //3.write
  void write(BVO bvo);

  //4.modify
  void modify(BVO bvo);

  //5.delete
  void delete(int bId);
}
