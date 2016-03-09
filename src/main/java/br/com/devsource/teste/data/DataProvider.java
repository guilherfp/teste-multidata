package br.com.devsource.teste.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author Guilherme Pacheco
 */
public final class DataProvider {

  private static final Logger LOGGER = LoggerFactory.getLogger(DataProvider.class);

  private static final Map<String, DataSource> SOURCES = new HashMap<>();

  static {
    SOURCES.put("empresa1:filial1", dataSource1());
    SOURCES.put("empresa2:filial2", dataSource2());
    LOGGER.info("DataProvider intialized!");
  }

  private static DataSource dataSource1() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    builder.setName("db1").setType(EmbeddedDatabaseType.H2);
    return builder.addScripts("schema1.sql").build();
  }

  private static DataSource dataSource2() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    builder.setName("db2").setType(EmbeddedDatabaseType.H2);
    return builder.addScripts("schema2.sql").build();
  }

  public Collection<DataSource> getDataSources() {
    return SOURCES.values();
  }

  public DataSource geData(Access access) {
    return SOURCES.get(String.format("%s:%s", access.getEmpresa(), access.getFilial()));
  }

}
