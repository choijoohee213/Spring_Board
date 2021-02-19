package webprj.board.vo;

import lombok.*;

import java.sql.Timestamp;

//TODO lombok의 @Data가 mybatis에서 불러올때 안먹음..

@Data
public class BVO {
  private int bId;
  private String bName;
  private String bTitle;
  private String bContent;
  private Timestamp bDate;
  private int bHit;
}
