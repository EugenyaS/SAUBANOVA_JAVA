package ru.saubanova.dto;

import lombok.Data;

@Data
public class UserDto {
  private String firstName;
  private String lastName;
  private String login;
  private String password;

}
