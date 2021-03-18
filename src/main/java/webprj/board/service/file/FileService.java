package webprj.board.service.file;

import webprj.board.vo.FileVO;

public interface FileService {
  FileVO getFileWithBID(int bId);

  FileVO getFileWithFID(int fId);

  void saveFile(FileVO fvo);
}
