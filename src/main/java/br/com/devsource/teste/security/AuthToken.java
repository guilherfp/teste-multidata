package br.com.devsource.teste.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.devsource.teste.data.Access;

/**
 * @author Guilherme Pacheco
 */
public class AuthToken extends UsernamePasswordAuthenticationToken implements Access {
  private static final long serialVersionUID = 1L;

  private final String filial;
  private final String empresa;

  public AuthToken(String usuario, String senha, String empresa, String filial) {
    super(usuario, senha);
    this.empresa = empresa;
    this.filial = filial;
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

}
