package br.com.devsource.teste.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author Guilherme Pacheco
 */
public final class DataConfig {

  private static Map<String, DataSource> DATASOURCES = new HashMap<>();

  static {
    DATASOURCES.put("empresa1:filial1", dataSource1());
    DATASOURCES.put("empresa2:filial2", dataSource2());
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

  public static DataSource geData(String empresa, String filial) {
    return DATASOURCES.get(String.format("%s:%s", empresa, filial));
  }

}
