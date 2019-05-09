package ru.saubanova.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.saubanova.app.dto.PostDto;
import ru.saubanova.app.models.Post;
import ru.saubanova.app.repositories.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
  @Autowired
  private PostRepository postRepository;

  @Override
  public List<PostDto> getPosts() {
    List<Post> posts = postRepository.findAll();
//    List<PostDTO> postsDTOs= new ArrayList<>();
//    for (Post post : posts) {
//      postsDTOs.add(new PostDTO(post));
//    }
//    return postDTOs;
    return posts.stream().map(PostDto::new).collect(Collectors.toList());
  }
}
