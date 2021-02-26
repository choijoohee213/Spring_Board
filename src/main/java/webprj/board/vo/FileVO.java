package webprj.board.vo;

import lombok.Data;

@Data
public class FileVO {
  private int fId;
  private int bId; //fk
  private String fOrgi_name;
  private String fName;
  private String fPath;
}
