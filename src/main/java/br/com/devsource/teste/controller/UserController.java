package br.com.devsource.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.devsource.teste.user.User;
import br.com.devsource.teste.user.UserRepository;

/**
 * @author Guilherme Pacheco
 */
@Controller
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @RequestMapping({ "", "/" })
  public String users(Model model) {
    model.addAttribute("users", userRepository.listAll());
    return "users";
  }

  @ResponseBody
  @RequestMapping("/all")
  public List<User> users() {
    return userRepository.listAll();
  }

}
