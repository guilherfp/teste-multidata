package br.com.devsource.teste.user;

import br.com.devsource.teste.security.Credentials;

/**
 * @author Guilherme Pacheco
 */
public class User implements Credentials {

  private String username;
  private String name;
  private String password;
  private boolean active;

  public User() {
    active = true;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (username == null ? 0 : username.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    User other = (User) obj;
    return username.equals(other.username);
  }

  @Override
  public String toString() {
    return String.format("User [username: %s, name: %s]", username, name);
  }

}
