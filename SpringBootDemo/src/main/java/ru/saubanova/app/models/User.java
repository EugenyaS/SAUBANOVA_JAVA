package ru.saubanova.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NaturalId
  private String login;
  private String password;
  @ManyToOne
  @JoinColumn(name="organization_id", nullable = false)
  private  Organization organization;
  @Enumerated (value=EnumType.STRING)
  private Role role;
  @OneToOne
  private  UserProfile userProfile;
}
