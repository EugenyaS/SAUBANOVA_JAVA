package ru.saubanova.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signIn")
public class SignInController {

  @Autowired
  PasswordEncoder passwordEncoder;

  @GetMapping
  public String getSignIn(){
    return "signIn";
  }

  @PostMapping
  public String signIn(){
    return "redirect:/users";
  }
}