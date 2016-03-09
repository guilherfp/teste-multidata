package br.com.devsource.teste.data;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.devsource.teste.data.DataProvider;
import br.com.devsource.teste.security.AuthToken;

/**
 * @author Guilherme Pacheco
 */
public class DataProviderTest {

  private DataProvider dataProvider;

  @Before
  public void setUp() throws Exception {
    dataProvider = new DataProvider();
  }

  @Test
  public void testGeData1() throws Exception {
    AuthToken token = new AuthToken("usuario", "senha", "empresa1", "filial1");
    DataSource datasource = dataProvider.geData(token);
    long count = count(datasource);
    assertEquals(15, count);
  }

  @Test
  public void testGeData2() throws Exception {
    AuthToken token = new AuthToken("usuario", "senha", "empresa2", "filial2");
    DataSource datasource = dataProvider.geData(token);
    long count = count(datasource);
    assertEquals(25, count);
  }

  private long count(DataSource datasource) {
    JdbcTemplate template = new JdbcTemplate(datasource);
    return template.queryForObject("select count(*) from user", Long.class);
  }

}
