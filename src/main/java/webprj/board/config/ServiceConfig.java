package webprj.board.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.IOException;

@Configuration
@ComponentScan("webprj.board.service")
@MapperScan("webprj.board.mapper")
public class ServiceConfig {

  //Mybatis - Spring, DataSource
  @Bean
  public SqlSessionFactoryBean sqlSessionFactory() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
    dataSource.setUsername("C##JH");
    dataSource.setPassword("1234");

    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);


    try {
      Resource[] arrResource;
      arrResource = new PathMatchingResourcePatternResolver()
            .getResources("classpath:mapper/*.xml");

      sqlSessionFactoryBean.setMapperLocations(arrResource);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sqlSessionFactoryBean;
  }
}
