package br.com.devsource.teste.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author Guilherme Pacheco
 */
@Component
public class AuthManager implements AuthenticationProvider, AuthenticationManager {

  private static final Logger LOGGER = LoggerFactory.getLogger(AuthManager.class);

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    LOGGER.info("Auth: {}", authentication);
    return authentication;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return AuthToken.class.isAssignableFrom(authentication);
  }

}
