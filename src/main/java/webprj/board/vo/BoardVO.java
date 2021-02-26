package webprj.board.vo;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Data
public class BoardVO {
  private int bId;
  private String bName;
  private String bTitle;
  private String bContent;
  private Timestamp bDate;
  private int bHit;
}
