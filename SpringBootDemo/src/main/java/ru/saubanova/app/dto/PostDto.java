package ru.saubanova.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.saubanova.app.models.Post;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
  Long id;
  String name;

  public PostDto(Post post) {
    this.id = post.getId();
    this.name = post.getName();
  }
}
