package br.com.devsource.teste.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.devsource.teste.data.AccessPoint;
import br.com.devsource.teste.user.User;

/**
 * @author Guilherme Pacheco
 */
public class AuthToken extends UsernamePasswordAuthenticationToken implements AccessPoint, Credentials {
  private static final long serialVersionUID = 1L;

  private final String filial;
  private final String empresa;

  public AuthToken(String usuario, String senha, String empresa, String filial) {
    super(usuario, senha);
    this.empresa = empresa;
    this.filial = filial;
  }

  public AuthToken(AccessPoint accessPoint, User user) {
    super(user.getUsername(), user.getPassword(), authorities());
    empresa = accessPoint.getEmpresa();
    filial = accessPoint.getFilial();
  }

  private static List<SimpleGrantedAuthority> authorities() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public String getFilial() {
    return filial;
  }

  @Override
  public String getEmpresa() {
    return empresa;
  }

  @Override
  public String toString() {
    return String.format("AuthToken [usuario: %s, empresa: %s, filial: %s]", getPrincipal(),
      empresa, filial);
  }

  @Override
  public String getUsername() {
    return String.valueOf(getPrincipal());
  }

  @Override
  public String getPassword() {
    return String.valueOf(getCredentials());
  }

}
