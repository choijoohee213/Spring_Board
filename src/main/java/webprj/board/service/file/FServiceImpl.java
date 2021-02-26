package webprj.board.service.file;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import webprj.board.mapper.FMapper;
import webprj.board.vo.FileVO;

@Service
@Log4j2
@Qualifier("fServiceImpl")
@AllArgsConstructor
public class FServiceImpl implements FService {

  private FMapper fMapper;

  @Override
  public FileVO getFile(int bId) {
    return fMapper.getFile(bId);
  }

  @Override
  public void saveFile(FileVO fvo) {
    fMapper.saveFile(fvo);
  }
}
