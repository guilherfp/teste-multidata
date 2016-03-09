package br.com.devsource.teste.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.devsource.teste.model.User;
import br.com.devsource.teste.security.AuthToken;

/**
 * @author Guilherme Pacheco
 */
public class UserRepositoryTest {

  private UserRepository userRepository;
  private DataProvider dataProvider;

  @Before
  public void setUp() throws Exception {
    dataProvider = new DataProvider();
  }

  @Test
  public void testListAll1() throws Exception {
    AuthToken token = new AuthToken("usuario", "senha", "empresa1", "filial1");
    userRepository = new UserRepository(() -> dataProvider.geData(token));
    List<User> users = userRepository.listAll();
    assertNotNull(users);
    assertEquals(15, users.size());
  }

  @Test
  public void testListAll2() throws Exception {
    AuthToken token = new AuthToken("usuario", "senha", "empresa2", "filial2");
    userRepository = new UserRepository(() -> dataProvider.geData(token));
    List<User> users = userRepository.listAll();
    assertNotNull(users);
    assertEquals(25, users.size());
  }

}
