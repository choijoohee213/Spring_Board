package webprj.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import webprj.board.vo.ReplyVO;

import java.util.List;

@Mapper
public interface ReplyMapper {
  //1.list
  List<ReplyVO> list(int bId);

  //2.write
  void write(ReplyVO rvo);

  //3.modify
  void modify(ReplyVO rvo);

  //4.delete
  void delete(int rId);
}
