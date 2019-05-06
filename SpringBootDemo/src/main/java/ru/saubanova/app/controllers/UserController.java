package ru.saubanova.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.saubanova.app.models.User;
import ru.saubanova.app.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("/users")
  public String getUsers(ModelMap model){
    List<User> users= new ArrayList<>();
    users = userService.getAllUsers();
    model.addAttribute("users", users);
    return "users";
  }

}
