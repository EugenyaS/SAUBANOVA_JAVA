package ru.saubanova.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.saubanova.app.dto.PostDto;
import ru.saubanova.app.services.PostService;


import java.util.List;

@RestController
public class PostController {
  @Autowired
  PostService postService;

  @RequestMapping(value = "/posts", method = RequestMethod.GET)
  public List<PostDto> getPost() {
    return  postService.getPosts();
  }

}
