package br.com.devsource.teste.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Guilherme Pacheco
 */
public class UserMapper implements RowMapper<User> {

  @Override
  public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    User user = new User();
    user.setName(rs.getString("name"));
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    return user;
  }

}
