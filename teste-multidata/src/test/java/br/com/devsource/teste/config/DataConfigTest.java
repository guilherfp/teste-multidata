package br.com.devsource.teste.config;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Guilherme Pacheco
 */
public class DataConfigTest {

  private String sql = "select count(*) from user";

  @Test
  public void testGeData1() throws Exception {
    DataSource datasource = DataConfig.geData("empresa1", "filial1");
    long count = count(datasource);
    assertEquals(15, count);
  }

  @Test
  public void testGeData2() throws Exception {
    DataSource datasource = DataConfig.geData("empresa2", "filial2");
    long count = count(datasource);
    assertEquals(25, count);
  }

  private long count(DataSource datasource) {
    JdbcTemplate template = new JdbcTemplate(datasource);
    return template.queryForObject(sql, Long.class);
  }

}
