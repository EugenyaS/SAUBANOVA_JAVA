package ru.saubanova.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.saubanova.app.models.Post;

public interface PostRepository  extends JpaRepository<Post, Long> {

}
