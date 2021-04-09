package webprj.board.service.board;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import webprj.board.mapper.ReplyMapper;
import webprj.board.vo.ReplyVO;

import java.util.List;

@Service
@Log4j2
@Qualifier("replyServiceImpl")
@AllArgsConstructor //생성자를 이용한 모든 속성을 자동 DI
public class ReplyServiceImpl implements ReplyService {

  //@AllArgsConstructor 이용해 자동 DI됨.
  private ReplyMapper replyMapper;

  @Override
  public List<ReplyVO> list(int bId) {
    return replyMapper.list(bId);
  }

  @Override
  public void write(ReplyVO rvo) {
    replyMapper.write(rvo);
  }

  @Override
  public void modify(ReplyVO rvo) {
    replyMapper.modify(rvo);
  }

  @Override
  public void delete(int rId) {
    replyMapper.delete(rId);
  }
}
