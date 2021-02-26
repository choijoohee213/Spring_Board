package webprj.board.service.file;

import webprj.board.vo.FileVO;

public interface FService {
  FileVO getFile(int bId);

  void saveFile(FileVO fvo);
}
