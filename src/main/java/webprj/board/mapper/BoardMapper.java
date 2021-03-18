package webprj.board.mapper;

import org.apache.ibatis.annotations.*;
import webprj.board.PageObject;
import webprj.board.vo.BoardVO;

import java.util.List;

@Mapper
public interface BoardMapper {
  //1.list
  List<BoardVO> list(PageObject pageObject);
  int getRow(PageObject pageObject);

  //2.view (조회수 1증가)
  BoardVO view(int bId);
  void increaseHit(int bId);

  //3.write
  void write(BoardVO bvo);

  //4.modify
  void modify(BoardVO bvo);

  //5.delete
  void delete(int bId);
}
