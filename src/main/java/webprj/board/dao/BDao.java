package webprj.board.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import webprj.board.dto.BDto;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class BDao {
  //@Autowired
  private DataSource dataSource;

  public BDao(){
    ApplicationContext context =
          new ClassPathXmlApplicationContext("classpath:service-context.xml");
    dataSource = context.getBean(org.springframework.jdbc.datasource.DriverManagerDataSource.class);
  }

  public ArrayList<BDto> list() {
    ArrayList<BDto> dtos = new ArrayList<>();
    String query = "select * from mvc_board order by bGroup desc, bStep asc";

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    try {
//      Class.forName("oracle.jdbc.driver.OracleDriver");
//      con = DriverManager.getConnection(url, user, pw);
      con = dataSource.getConnection();
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
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return dtos;
  }

  public void write(String bName, String bTitle, String bContent) {
    String query = "insert into MVC_BOARD(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) " +
          "values (mvc_board_seq.nextval,?,?,?,0,mvc_board_seq.currval,0,0)";

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {
      con = dataSource.getConnection();
      pst = con.prepareStatement(query);

      pst.setString(1,bName);
      pst.setString(2,bTitle);
      pst.setString(3,bContent);
      pst.executeUpdate();

      if(pst != null) pst.close();
      if(con != null) con.close();

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public BDto contentView(String id) {
    upHit(id);

    String query = "select * from mvc_board where bId=?";

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    BDto dto = null;

    try {
      con = dataSource.getConnection();
      pst = con.prepareStatement(query);
      pst.setInt(1,Integer.parseInt(id));
      rs = pst.executeQuery();

      if(rs.next()) {
        int bId = rs.getInt("bId");
        String bName = rs.getString("bName");
        String bTitle = rs.getString("bTitle");
        String bContent = rs.getString("bContent");
        Timestamp bDate = rs.getTimestamp("bDate");
        int bHit = rs.getInt("bHit");
        int bGroup = rs.getInt("bGroup");
        int bStep = rs.getInt("bStep");
        int bIndent = rs.getInt("bIndent");

        dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
      }
      if(rs != null) rs.close();
      if(pst != null) pst.close();
      if(con != null) con.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return dto;
  }

  public void upHit(String id){
    String query = "update mvc_board set bHit = bHit+1 where bId = ?";

    Connection con = null;
    PreparedStatement pst = null;

    try {
      con = dataSource.getConnection();
      pst = con.prepareStatement(query);
      pst.setInt(1,Integer.parseInt(id));
      pst.executeUpdate();

      if(pst != null) pst.close();
      if(con != null) con.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
