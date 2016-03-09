package br.com.devsource.teste.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.devsource.teste.security.AuthFilter;
import br.com.devsource.teste.security.AuthManager;

/**
 * @author Guilherme Pacheco
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements InitializingBean {

  @Autowired
  private AuthManager authManager;
  private AuthFilter authFilter;

  @Override
  public void afterPropertiesSet() throws Exception {
    authFilter = new AuthFilter();
    authFilter.setAuthenticationManager(authManager);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .addFilter(authFilter)
      .authorizeRequests()
      .anyRequest().authenticated()
      .and()
      .formLogin()
      .loginPage("/login")
      .defaultSuccessUrl("/users", true)
      .permitAll()
      .and()
      .logout().permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authManager);
  }

}
