package webprj.board.service.board;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import webprj.board.PageObject;
import webprj.board.mapper.BoardMapper;
import webprj.board.vo.BoardVO;

import java.util.List;

@Service
@Log4j2
@Qualifier("boardServiceImpl")
@AllArgsConstructor //생성자를 이용한 모든 속성을 자동 DI
public class BoardServiceImpl implements BoardService {

  //@AllArgsConstructor 이용해 자동 DI됨.
  private BoardMapper boardMapper;

  public BoardMapper getbMapper(){
    return boardMapper;
  }

  @Override
  public List<BoardVO> list(PageObject pageObject) {
    pageObject.setTotalRow(boardMapper.getRow(pageObject));
    return boardMapper.list(pageObject);
  }

  @Override
  public BoardVO view(int bId) {
    boardMapper.increaseHit(bId); //조회수 증가
    return boardMapper.view(bId);
  }

  @Override
  public void write(BoardVO bvo) {
    boardMapper.write(bvo);
  }

  @Override
  public void modify(BoardVO bvo) {
    boardMapper.modify(bvo);
  }

  @Override
  public void delete(int bId) {
    boardMapper.delete(bId);
  }
}
