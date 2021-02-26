package webprj.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import webprj.board.vo.FileVO;

@Mapper
public interface FMapper {

  FileVO getFile(int bId);

  void saveFile(FileVO fvo);
}
