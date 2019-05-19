package ru.saubanova.app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.saubanova.app.models.Post;

import javax.validation.constraints.NegativeOrZero;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDictDto extends BaseDto<Post> {
  private String name;
  public PostDictDto(Post post){
    super(post);
    this.name = post.getName();
  }

}
