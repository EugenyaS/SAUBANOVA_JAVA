package ru.saubanova.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.saubanova.app.dto.PostDto;
import ru.saubanova.app.models.Post;
import ru.saubanova.app.repositories.PostRepository;

@Component
public class PostDtoConverter implements BaseDtoConverter<Post, PostDto> {

  @Autowired
  private PostRepository postRepository;

  @Override
  public Post toEntity(PostDto dto) {
    if (dto == null) return null;
    Post post;
    if (dto.getId() == null) {
      post = new Post();
    } else {
      post = postRepository.getOne(dto.getId());
    }
    post.setName(dto.getName());
    post.setCode(dto.getCode());
    return post;
  }
}
