package ru.saubanova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.saubanova.dto.UserDto;
import ru.saubanova.models.User;
import ru.saubanova.services.UserService;

import java.util.List;

@Controller
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("/users")
  public ModelAndView getUserPages(){
    List<User> users = userService.getAllUsers();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("users", users);
    modelAndView.setViewName("users_pages");
    return  modelAndView;
  }

  @PostMapping("/users")
  public String addUsers(UserDto userDto){
    userService.addUser(userDto);
    return "redirect:/users";
  }
}
