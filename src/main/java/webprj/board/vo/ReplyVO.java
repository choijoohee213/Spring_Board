package webprj.board.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ReplyVO {
  private int rId;
  private int bId;  //fk
  private String rName;
  private String rContent;
  private Timestamp rDate;

  public int getrId() {
    return rId;
  }

  public void setrId(int rId) {
    this.rId = rId;
  }

  public int getbId() {
    return bId;
  }

  public void setbId(int bId) {
    this.bId = bId;
  }

  public String getrName() {
    return rName;
  }

  public void setrName(String rName) {
    this.rName = rName;
  }

  public String getrContent() {
    return rContent;
  }

  public void setrContent(String rContent) {
    this.rContent = rContent;
  }

  public Timestamp getrDate() {
    return rDate;
  }

  public void setrDate(Timestamp rDate) {
    this.rDate = rDate;
  }
}
