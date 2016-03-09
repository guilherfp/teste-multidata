package br.com.devsource.teste.user;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.devsource.teste.data.DataProvider;
import br.com.devsource.teste.security.AuthToken;
import br.com.devsource.teste.user.User;
import br.com.devsource.teste.user.UserRepository;

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

  @Test
  public void testWithCredentials_InvalidCretentials() throws Exception {
    AuthToken token = new AuthToken("usuario", "senha", "empresa2", "filial2");
    userRepository = new UserRepository(() -> dataProvider.geData(token));
    User user = userRepository.withCredentials(token);
    assertNull(user);
  }

  @Test
  public void testWithCredentials() throws Exception {
    AuthToken token = new AuthToken("user120", "120", "empresa2", "filial2");
    userRepository = new UserRepository(() -> dataProvider.geData(token));
    User user = userRepository.withCredentials(token);
    assertNotNull(user);
  }

}
