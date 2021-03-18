package webprj.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import webprj.board.vo.FileVO;

@Mapper
public interface FileMapper {

  FileVO getFileWithBID(int bId);

  FileVO getFileWithFID(int fId);

  void saveFile(FileVO fvo);
}
