package webprj.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ReplyObject {
  private int bId;
  private int startCnt;
  private int endCnt;

  public int getbId() {
    return bId;
  }

  public void setbId(int bId) {
    this.bId = bId;
  }

  public int getStartCnt() {
    return startCnt;
  }

  public void setStartCnt(int startCnt) {
    this.startCnt = startCnt;
  }

  public int getEndCnt() {
    return endCnt;
  }

  public void setEndCnt(int endCnt) {
    this.endCnt = endCnt;
  }
}
