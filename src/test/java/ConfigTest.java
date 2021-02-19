import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import webprj.board.config.ServiceConfig;
import webprj.board.service.BServiceImpl;

import javax.sql.DataSource;
import java.sql.SQLException;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class ConfigTest {

  @Autowired
  DataSource dataSource;

  @Autowired
  SqlSessionFactoryBean sqlSessionFactory;

  @Autowired
  BServiceImpl service;

  @Test
  public void checkBeans(){
    log.info("--------check 빈------");
    log.info(dataSource);
    try {
      log.info(dataSource.getConnection());
      log.info(sqlSessionFactory);
      log.info(sqlSessionFactory.getDatabaseIdProvider());
      log.info(service);
      log.info(service.getbMapper());
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
