package ru.saubanova.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.saubanova.app.models.Post;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto extends PostDictDto {

  private String code;
  public PostDto(Post post) {
    super(post);
    this.code = post.getCode();
  }
}
