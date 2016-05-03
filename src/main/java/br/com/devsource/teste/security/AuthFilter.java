package br.com.devsource.teste.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Guilherme Pacheco
 */
public class AuthFilter extends UsernamePasswordAuthenticationFilter {

  private static final String EMPRESA_PARAM = "empresa";
  private static final String FILIAL_PARAM = "filial";

  @Override
  public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {
    String method = req.getMethod();
    SecurityUtils.isTrue("POST".equals(method), "Autenticação não suporta método: " + method);

    String empresa = empresa(req);
    String filial = filial(req);
    String username = username(req);
    String password = password(req);

    AuthToken token = new AuthToken(username, password, empresa, filial);

    setDetails(req, token);
    return getAuthenticationManager().authenticate(token);
  }

  private String empresa(HttpServletRequest request) {
    return extractParam(request, EMPRESA_PARAM, "Empresa obrigatória");
  }

  private String filial(HttpServletRequest request) {
    return extractParam(request, FILIAL_PARAM, "Filial obrigatória");
  }

  private String password(HttpServletRequest request) {
    String password = obtainPassword(request);
    SecurityUtils.notBlank(password, "Senha obrigatória");
    return password;
  }

  private String username(HttpServletRequest request) {
    String username = obtainUsername(request);
    SecurityUtils.notBlank(username, "Login obrigatório");
    return username;
  }

  private String extractParam(HttpServletRequest request, String param, String message) {
    String empresa = request.getParameter(param);
    SecurityUtils.notBlank(empresa, message);
    return empresa;
  }

}
