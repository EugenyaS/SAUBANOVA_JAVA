package ru.saubanova.app.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.saubanova.app.dto.UserDto;
import ru.saubanova.app.models.User;
import ru.saubanova.app.security.UserDetailsImpl;

@Controller
@RequestMapping("/profile")
public class ProfileController {
  @GetMapping
  public String getProfilePage(Authentication authentication, ModelMap model){
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    User user = userDetails.getUser();
    model.addAttribute("user", new UserDto(user));
    return "profile";
  }
}
