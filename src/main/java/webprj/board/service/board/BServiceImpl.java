package webprj.board.service.board;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import webprj.board.PageObject;
import webprj.board.mapper.BMapper;
import webprj.board.vo.BoardVO;

import java.util.List;

@Service
@Log4j2
@Qualifier("bServiceImpl")
@AllArgsConstructor //생성자를 이용한 모든 속성을 자동 DI
public class BServiceImpl implements BService{

  //@AllArgsConstructor 이용해 자동 DI됨.
  private BMapper bMapper;

  public BMapper getbMapper(){
    return bMapper;
  }

  @Override
  public List<BoardVO> list(PageObject pageObject) {
    log.info("---게시판 목록 ----");
    pageObject.setTotalRow(bMapper.getRow(pageObject));
    log.info(pageObject);
    return bMapper.list(pageObject);
  }

  @Override
  public BoardVO view(int bId) {
    bMapper.increaseHit(bId); //조회수 증가
    return bMapper.view(bId);
  }

  @Override
  public void write(BoardVO bvo) {
    bMapper.write(bvo);
  }

  @Override
  public void modify(BoardVO bvo) {
    bMapper.modify(bvo);
  }

  @Override
  public void delete(int bId) {
    bMapper.delete(bId);
  }
}
