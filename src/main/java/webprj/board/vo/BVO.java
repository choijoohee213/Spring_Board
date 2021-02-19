package webprj.board.vo;

import lombok.*;

import java.sql.Timestamp;

@Data
public class BVO {
  private int bId;
  private String bName;
  private String bTitle;
  private String bContent;
  private Timestamp bDate;
  private int bHit;
}
