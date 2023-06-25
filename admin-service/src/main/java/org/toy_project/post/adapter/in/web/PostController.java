package org.toy_project.post.adapter.in.web;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toy_project.post.adapter.out.persistence.Post;
import org.toy_project.post.application.port.in.GetPostUseCase;
import org.toy_project.response.ApiResponse;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final GetPostUseCase getPostUseCase;


    @GetMapping
    public ApiResponse<List<Post>> getPosts() {
        return ApiResponse.ok(getPostUseCase.getPosts());
    }


    @GetMapping("/{id}")
    public ApiResponse<Post> getPost(@PathVariable Long id) {
        Post post = getPostUseCase.getPost(id);
        return ApiResponse.ok(post);
    }
}
