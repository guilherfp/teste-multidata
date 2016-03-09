package br.com.devsource.teste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Guilherme Pacheco
 */
@Controller
@RequestMapping("/")
public class HomeController {

  @RequestMapping("")
  public String users() {
    return "redirect:users";
  }

  @RequestMapping("/login")
  public String loggin() {
    return "login";
  }
}
