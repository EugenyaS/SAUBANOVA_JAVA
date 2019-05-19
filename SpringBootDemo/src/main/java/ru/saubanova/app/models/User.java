package ru.saubanova.app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="users")
public class User implements IEntity {
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
  @ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
  @JoinColumn(name = "user_profile_id")
  private UserProfile userProfile;
}
