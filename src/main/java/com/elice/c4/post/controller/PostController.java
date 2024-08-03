package com.elice.c4.post.controller;

import com.elice.c4.post.domain.Post;
import com.elice.c4.post.dto.PostDTO;
import com.elice.c4.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody PostDTO postDTO) {
        return postService.savePost(postDTO);
    }

    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable("id") Long id, @RequestBody PostDTO postDTO) {
        return postService.updatePost(id, postDTO);
    }

    // todo delete 구현
    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }
}
