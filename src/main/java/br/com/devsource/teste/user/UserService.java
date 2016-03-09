package br.com.devsource.teste.user;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.devsource.teste.data.DataProvider;

/**
 * @author Guilherme Pacheco
 */
@Service
public class UserService {

  @Autowired
  private DataProvider dataProvider;

  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  @Scheduled(initialDelay = 5000, fixedDelay = 10000)
  public void listUsers() {
    for (DataSource dataSource : dataProvider.getDataSources()) {
      UserRepository userRepository = new UserRepository(() -> dataSource);
      LOGGER.info("All User: {}", userRepository.listAll());
    }
  }

}
