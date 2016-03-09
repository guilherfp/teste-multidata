package br.com.devsource.teste.data;

import javax.sql.DataSource;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.devsource.teste.security.AuthToken;

/**
 * @author Guilherme Pacheco
 */
public class SessionDatasSourcebuilder implements DataSourceBuilder {

  @Override
  public DataSource getDataSource() {
    return null;
  }

  private AuthToken getAuthToken() {
    return (AuthToken) SecurityContextHolder.getContext().getAuthentication();
  }

}
