package org.toy_project.post.adapter.in.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toy_project.post.adapter.out.persistence.Post;
import org.toy_project.post.application.port.in.GetPostUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final GetPostUseCase getPostUseCase;


    @GetMapping
    public ResponseEntity<List<Post>> getPostList() {

        List<Post> postList = getPostUseCase.getPostList();
        return ResponseEntity.ok().body(postList);
    }


    @GetMapping("/{postId}")
    public ResponseEntity<Map<String, Object>> getPost(@PathVariable Long postId) {
        Map<String, Object> resultMap = new HashMap<>();
        Post post = getPostUseCase.getPost(postId);

        resultMap.put("post", post);
        return ResponseEntity.ok().body(resultMap);
    }
}
