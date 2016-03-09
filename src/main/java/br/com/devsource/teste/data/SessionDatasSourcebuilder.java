package br.com.devsource.teste.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.devsource.teste.security.AuthToken;

/**
 * @author Guilherme Pacheco
 */
@Component
public class SessionDatasSourcebuilder implements DataSourceBuilder {

  @Autowired
  private DataProvider dataProvider;

  @Override
  public DataSource getDataSource() {
    AuthToken token = getAuthToken();
    return dataProvider.geData(token);
  }

  private AuthToken getAuthToken() {
    return (AuthToken) SecurityContextHolder.getContext().getAuthentication();
  }

}
