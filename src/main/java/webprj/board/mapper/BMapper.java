package webprj.board.mapper;

import org.apache.ibatis.annotations.*;
import webprj.board.PageObject;
import webprj.board.vo.BVO;

import java.util.List;

@Mapper
public interface BMapper {
  //1.list
  List<BVO> list(PageObject pageObject);
  int getRow(PageObject pageObject);

  //2.view (조회수 1증가)
  BVO view(int bId);
  void increaseHit(int bId);

  //3.write
  void write(BVO bvo);

  //4.modify
  void modify(BVO bvo);

  //5.delete
  void delete(int bId);
}
