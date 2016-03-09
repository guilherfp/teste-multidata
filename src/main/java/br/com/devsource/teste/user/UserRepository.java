package br.com.devsource.teste.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.devsource.teste.data.DataSourceBuilder;
import br.com.devsource.teste.security.Credentials;

/**
 * @author Guilherme Pacheco
 */
@Repository
public class UserRepository {

  private DataSourceBuilder dataSourceBuilder;

  @Autowired
  public UserRepository(DataSourceBuilder dataSourceBuilder) {
    this.dataSourceBuilder = dataSourceBuilder;
  }

  private RowMapper<User> mapper = new UserMapper();

  public List<User> listAll() {
    return template().query("select * from user", mapper);
  }

  public User withCredentials(Credentials cred) {
    try {
      String sql = "select * from user where username = ? and password = ?";
      return template().queryForObject(sql, mapper, cred.getUsername(), cred.getPassword());
    } catch (EmptyResultDataAccessException ex) {
      return null;
    }
  }

  private JdbcTemplate template() {
    return new JdbcTemplate(dataSourceBuilder.getDataSource());
  }

}
