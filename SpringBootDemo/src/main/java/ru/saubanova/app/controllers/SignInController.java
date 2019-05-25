package ru.saubanova.app.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signIn")
public class SignInController {

  @GetMapping
  @PreAuthorize("permitAll()")
  public String getSignIn(){
    return "signIn";
  }

  @PostMapping
  @PreAuthorize("permitAll()")
  public  String  signIn(){
    return "redirect:/profile";
  }
}
