package br.com.devsource.teste.data;

import javax.sql.DataSource;

/**
 * @author Guilherme Pacheco
 */
@FunctionalInterface
public interface DataSourceHelper {

  DataSource get();

}
