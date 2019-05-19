package ru.saubanova.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.saubanova.app.models.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
