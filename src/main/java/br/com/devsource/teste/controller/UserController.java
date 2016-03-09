package br.com.devsource.teste.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.devsource.teste.data.UserRepository;
import br.com.devsource.teste.model.User;

/**
 * @author Guilherme Pacheco
 */
@Controller
@RequestMapping("/users")
public class UserController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserRepository userRepository;

  @RequestMapping({ "", "/" })
  public String users(Model model) {
    List<User> allUsers = userRepository.allUsers();
    LOGGER.info("Users: {}", allUsers);
    model.addAttribute("users", allUsers);
    return "users";
  }
}
