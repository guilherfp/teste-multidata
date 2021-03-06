package br.com.devsource.teste.security;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import br.com.devsource.teste.data.AccessPoint;
import br.com.devsource.teste.data.DataProvider;
import br.com.devsource.teste.data.DataSourceHelper;
import br.com.devsource.teste.user.User;
import br.com.devsource.teste.user.UserRepository;

/**
 * @author Guilherme Pacheco
 */
@Component
public class AuthManager implements AuthenticationProvider, AuthenticationManager {

  private static final Logger LOGGER = LoggerFactory.getLogger(AuthManager.class);

  @Autowired
  private DataProvider dataProvider;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    AuthToken token = (AuthToken) authentication;
    User user = user(token);
    validateUser(user);
    return newToken(token, user);
  }

  private Authentication newToken(AccessPoint accessPoint, User user) {
    AuthToken token = new AuthToken(accessPoint, user);
    LOGGER.info("New licensed user: {}", user);
    return token;
  }

  private User user(AuthToken token) {
    DataSourceHelper dataSourceBuilder = datasourceBuilder(token);
    UserRepository userRepository = new UserRepository(dataSourceBuilder);
    return userRepository.withCredentials(token);
  }

  private DataSourceHelper datasourceBuilder(AuthToken token) {
    DataSource dataSource = dataProvider.geData(token);
    SecurityUtils.notNull(dataSource, "Empresa e/ou filial inválidos");
    return () -> dataSource;
  }

  private void validateUser(User user) {
    SecurityUtils.notNull(user, "Usuário e/ou senha inválidos");
    SecurityUtils.isTrue(user.isActive(), "Usuário está desativado");
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return AuthToken.class.isAssignableFrom(authentication);
  }

}
