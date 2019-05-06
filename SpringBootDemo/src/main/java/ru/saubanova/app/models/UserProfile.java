package ru.saubanova.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserProfile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String lastName;
  private String firstName;
  private String patronymic;
  @ManyToOne
  @JoinColumn(name = "post_id", nullable = false)
  private Post postId;
  @OneToOne(mappedBy = "userProfile")
  private User user;
}
