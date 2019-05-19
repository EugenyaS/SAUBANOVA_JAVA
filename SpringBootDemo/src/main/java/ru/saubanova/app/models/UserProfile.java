package ru.saubanova.app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserProfile implements IEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String lastName;
  private String firstName;
  private String patronymic;
  private String email;
  @ManyToOne
  @JoinColumn(name = "post_id", nullable = false)
  private Post post;
}
