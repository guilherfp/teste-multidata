package br.com.devsource.teste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Guilherme Pacheco
 */
@Controller
@RequestMapping("/")
public class HomeController {

  @RequestMapping("/login")
  public String loggin(Model model) {
    return "login";
  }
}
