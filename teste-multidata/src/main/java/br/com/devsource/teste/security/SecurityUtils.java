package br.com.devsource.teste.security;

import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Guilherme Pacheco
 */
public final class SecurityUtils {

  private static final String ANONYMOUS = "ROLE_ANONYMOUS";

  private SecurityUtils() {
    super();
  }

  public static boolean isAuthenticated(Authentication auth) {
    return auth == null ? false : auth.getAuthorities().stream().anyMatch(noAnonymous());
  }

  private static Predicate<GrantedAuthority> noAnonymous() {
    return a -> !a.getAuthority().equalsIgnoreCase(ANONYMOUS);
  }

  public static void notNull(Object value, String message) {
    if (value == null) {
      throw new AuthenticationServiceException(message);
    }
  }

  public static void isTrue(boolean value, String message) {
    if (!value) {
      throw new AuthenticationServiceException(message);
    }
  }

  public static void notBlank(String value, String message) {
    if (StringUtils.isBlank(value)) {
      throw new AuthenticationServiceException(message);
    }
  }
}
