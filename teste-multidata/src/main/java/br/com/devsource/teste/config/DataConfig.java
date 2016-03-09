package br.com.devsource.teste.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.devsource.teste.data.DataProvider;

/**
 * @author Guilherme Pacheco
 */
@Configuration
public class DataConfig {

  @Bean
  private DataProvider dataProvider() {
    return new DataProvider();
  }

}
