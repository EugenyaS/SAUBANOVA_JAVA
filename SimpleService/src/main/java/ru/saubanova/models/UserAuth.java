package ru.saubanova.models;

import lombok.*;

import java.time.LocalDateTime;


@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserAuth {
  private Long id;
  private User user;
  private String cookieValue;
  private LocalDateTime lastLogin;

}
