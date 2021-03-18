package webprj.board.service.file;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import webprj.board.mapper.FileMapper;
import webprj.board.vo.FileVO;

@Service
@Log4j2
@Qualifier("fileServiceImpl")
@AllArgsConstructor
public class FileServiceImpl implements FileService {

  private FileMapper fileMapper;

  @Override
  public FileVO getFileWithBID(int bId) {
    return fileMapper.getFileWithBID(bId);
  }

  @Override
  public FileVO getFileWithFID(int fId) {
    return fileMapper.getFileWithFID(fId);
  }

  @Override
  public void saveFile(FileVO fvo) {
    fileMapper.saveFile(fvo);
  }
}
