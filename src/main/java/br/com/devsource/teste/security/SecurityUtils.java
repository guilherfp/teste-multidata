package br.com.devsource.teste.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Guilherme Pacheco
 */
final class SecurityUtils {

  private SecurityUtils() {
    super();
  }

  public static void notNull(Object value, String message) {
    if (value == null) {
      throw new AuthenticationCredentialsNotFoundException(message);
    }
  }

  public static void isTrue(boolean value, String message) {
    if (!value) {
      throw new LockedException(message);
    }
  }

  public static void notBlank(String value, String message) {
    if (StringUtils.isBlank(value)) {
      throw new UsernameNotFoundException(message);
    }
  }

}
