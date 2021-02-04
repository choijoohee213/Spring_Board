package webprj.board.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webprj.board.dto.BDto;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Service
public class BDao {
  String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
  String user = "NEWLEC";
  String pw = "12345";

  @Autowired
  private DataSource dataSource;

  public ArrayList<BDto> list() {
    ArrayList<BDto> dtos = new ArrayList<>();
    String query = "select * from mvc_board order by bGroup desc, bStep asc";

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con = DriverManager.getConnection(url, user, pw);
      pst = con.prepareStatement(query);
      rs = pst.executeQuery();

      while(rs.next()){
        int bId = rs.getInt("bId");
        String bName = rs.getString("bName");
        String bTitle = rs.getString("bTitle");
        String bContent = rs.getString("bContent");
        Timestamp bDate = rs.getTimestamp("bDate");
        int bHit = rs.getInt("bHit");
        int bGroup = rs.getInt("bGroup");
        int bStep = rs.getInt("bStep");
        int bIndent = rs.getInt("bIndent");

        BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
        dtos.add(dto);
      }

      if(rs != null) rs.close();
      if(pst != null) pst.close();
      if(con != null) con.close();
    } catch (SQLException | ClassNotFoundException throwables) {
      throwables.printStackTrace();
    }


    return dtos;
  }
}
