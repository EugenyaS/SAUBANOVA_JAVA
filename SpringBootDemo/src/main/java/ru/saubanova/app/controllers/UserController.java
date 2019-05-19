package ru.saubanova.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.saubanova.app.dto.UserDto;
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
    List<UserDto> users= new ArrayList<>();
    users = userService.getAllUsers();
    model.addAttribute("users", users);
    return "users";
  }

  @PostMapping("users/add")
  @ResponseBody
  public  List<UserDto> addUser(@RequestBody UserDto user){
    userService.saveUser(user);
    return userService.getAllUsers();
  }
}
