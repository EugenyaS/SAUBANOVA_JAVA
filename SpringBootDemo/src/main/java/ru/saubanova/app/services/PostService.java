package ru.saubanova.app.services;

import ru.saubanova.app.dto.PostDto;

import java.util.List;

public interface PostService {
  List<PostDto> getPosts();
}
