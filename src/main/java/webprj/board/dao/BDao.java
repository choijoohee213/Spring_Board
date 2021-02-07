package webprj.board.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import webprj.board.dto.BDto;
import webprj.board.util.Constant;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BDao {
  //@Autowired
  private DataSource dataSource;

  JdbcTemplate template;

  public BDao(){
    template = Constant.template;
  }

  public ArrayList<BDto> list() {
    String query = "select * from mvc_board order by bGroup desc, bStep asc";
    return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<>(BDto.class));
  }

  public void write(final String bName, final String bTitle, final String bContent) {
    String query = "insert into MVC_BOARD(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) " +
          "values (mvc_board_seq.nextval,?,?,?,0,mvc_board_seq.currval,0,0)";
    template.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,bName);
        pst.setString(2,bTitle);
        pst.setString(3,bContent);
        return pst;
      }
    });
  }

  public BDto contentView(int bId) {
    upHit(bId);
    String query = "select * from mvc_board where bId=?";
    return template.query(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1,bId);
      }
    }, new BeanPropertyRowMapper<>(BDto.class)).get(0);
    //return template.queryForObject(query, new BeanPropertyRowMapper<>(BDto.class));

  }

  public void upHit(final int bId){
    String query = "update mvc_board set bHit = bHit+1 where bId = ?";
    template.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1,bId);
      }
    });
  }

  public void modify(int bId, String bName, String bTitle, String bContent) {
    String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? " +
          "where bId = ?";
    template.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, bName);
        preparedStatement.setString(2, bTitle);
        preparedStatement.setString(3, bContent);
        preparedStatement.setInt(4,bId);
      }
    });
  }

  public void delete(int bId) {
    String query = "delete from mvc_board where bId = ?";
    template.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, bId);
      }
    });
  }

  public BDto reply_view(int bId) {
    String query = "select * from mvc_board where bId = ?";
    return template.query(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1,bId);
      }
    }, new BeanPropertyRowMapper<>(BDto.class)).get(0);
  }

  public void reply(String bName, String bTitle, String bContent, int bGroup, int bStep, int bIndent) {
    replyShape(bGroup, bStep);

    String query = "insert into MVC_BOARD(bId, bName, bTitle, bContent, bGroup, bStep, bIndent) " +
          "values (mvc_board_seq.nextval,?,?,?,?,?,?)";
    template.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1,bName);
        preparedStatement.setString(2,bTitle);
        preparedStatement.setString(3,bContent);
        preparedStatement.setInt(4,bGroup);
        preparedStatement.setInt(5,bStep+1);
        preparedStatement.setInt(6,bIndent+1);
      }
    });

  }

  private void replyShape(int bGroup, int bStep) {
    String query = "update mvc_board set bStep = bStep+1 where bGroup = ? and bStep > ?";
    template.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, bGroup);
        preparedStatement.setInt(2, bStep);
      }
    });
  }
}
