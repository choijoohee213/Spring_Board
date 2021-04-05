package webprj.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import webprj.board.PageObject;
import webprj.board.ReplyObject;
import webprj.board.vo.ReplyVO;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReplyMapper {
  //1.list
  List<ReplyVO> list(ReplyObject replyInfo);

  //2.write
  void write(ReplyVO rvo);

  //3.modify
  void modify(ReplyVO rvo);

  //4.delete
  void delete(int rId);
}
