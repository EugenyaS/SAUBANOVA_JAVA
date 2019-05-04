package ru.saubanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.saubanova.dto.AuthUserDto;
import ru.saubanova.dto.UserDto;
import ru.saubanova.services.UserAuthService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class AuthController {

  @Autowired
  private UserAuthService service;

  @GetMapping("/signUp")
  public String getSignUpPage() {
    return "sign_up";
  }

  @GetMapping("/signIn")
  public String getSignInPage() {
    return "sign_in";
  }

  @PostMapping("/signUp")
  public String signUp(UserDto userDto) {
    service.signUp(userDto);
    return "redirect:/signIn";
  }

  @PostMapping("/signIn")
  public String signIn(AuthUserDto authDto, HttpServletResponse response) {
    Optional<String> cookieValue = service.signInAndCreateCookie(authDto);
    if (cookieValue.isPresent()) {
      response.addCookie(new Cookie("CLIENT_ID", cookieValue.get()));
      return "redirect:/";
    } else {
      return "redirect:/signIn";
    }
  }

}
