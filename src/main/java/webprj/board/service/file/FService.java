package webprj.board.service.file;

import webprj.board.vo.FileVO;

public interface FService {
  FileVO getFileWithBID(int bId);

  FileVO getFileWithFID(int fId);

  void saveFile(FileVO fvo);
}
