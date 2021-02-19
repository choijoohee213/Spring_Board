package webprj.board.mapper;

import org.apache.ibatis.annotations.*;
import webprj.board.vo.BVO;

import java.util.List;

@Mapper
public interface BMapper {
  //1.list
  @Select("select * from mvc_board order by bId desc")
  List<BVO> list();
  int getRow();

  //2.view (조회수 1증가)
  @Select("select * from mvc_board where bId = #{bId}")
  BVO view(int bId);
  @Update("update mvc_board set bHit = bHit+1 where bId = #{bId}")
  void increaseHit(int bId);

  //3.write
  @Insert("insert into mvc_board(bId, bName, bTitle, bContent, bHit) " +
        "values (mvc_board_seq.nextval, #{bName}, #{bTitle}, #{bContent}, 0)")
  void write(BVO bvo);

  //4.modify
  @Update("update mvc_board set bName = #{bName}, bTitle = #{bTitle}, bContent = #{bContent} where bId = #{bId}")
  void modify(BVO bvo);

  //5.delete
  @Delete("delete from mvc_board where bId = #{bId}")
  void delete(int bId);
}
