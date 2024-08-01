package com.elice.c4.post.service;

import com.elice.c4.post.domain.Post;
import com.elice.c4.post.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    List<Post> data = new ArrayList<>();

    private Long generateId() {
        if(data.isEmpty()) return 1L;
        return data.getLast().getId() + 1;
    }

    public List<Post> getAllPosts() {

        return data;
    }

    public Post savePost(PostDTO postDTO) {

        Post post = new Post(generateId(), postDTO.getTitle(), postDTO.getContent());
        data.add(post);

        return post;
    }
}
