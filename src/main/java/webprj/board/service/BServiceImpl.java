package webprj.board.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import webprj.board.PageObject;
import webprj.board.mapper.BMapper;
import webprj.board.vo.BVO;

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
  public List<BVO> list(PageObject pageObject) {
    log.info("---게시판 목록 ----");
    pageObject.setTotalRow(bMapper.getRow());
    log.info(pageObject);
    return bMapper.list(pageObject);
  }

  @Override
  public BVO view(int bId) {
    bMapper.increaseHit(bId); //조회수 증가
    return bMapper.view(bId);
  }

  @Override
  public void write(BVO bvo) {
    bMapper.write(bvo);
  }

  @Override
  public void modify(BVO bvo) {
    bMapper.modify(bvo);
  }

  @Override
  public void delete(int bId) {
    bMapper.delete(bId);
  }
}
