package ru.saubanova.app.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
  @GetMapping("/")
  //@PreAuthorize("permitAll()")
// public String getRootPage(Authentication authentication) {
 public String getRootPage() {
//    if (authentication != null) {
//      return "redirect:/profile";
//    } else {
      return "redirect:/signIn";
//    }
  }
}