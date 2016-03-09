package br.com.devsource.teste.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.devsource.teste.model.User;

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
  public void testAllUsers1() throws Exception {
    userRepository = new UserRepository(() -> dataProvider.geData("empresa1", "filial1"));
    List<User> users = userRepository.allUsers();
    assertNotNull(users);
    assertEquals(15, users.size());
  }

  @Test
  public void testAllUsers2() throws Exception {
    userRepository = new UserRepository(() -> dataProvider.geData("empresa2", "filial2"));
    List<User> users = userRepository.allUsers();
    assertNotNull(users);
    assertEquals(25, users.size());
  }

}
