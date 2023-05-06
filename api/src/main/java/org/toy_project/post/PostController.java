package org.toy_project.post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toy_project.post.dto.PostResponse;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @GetMapping
    public List<PostResponse> getItems() {
        PostResponse firstPost = PostResponse.builder()
                .title("게시글 제목")
                .description("게시글 내용")
                .imageUrl("https://imageUrl.com")
                .build();

        PostResponse secondPost = PostResponse.builder()
                .title("두번째 게시글 제목")
                .description("두번째 게시글 내용")
                .imageUrl("https://imageUrl1.com")
                .build();

        return Arrays.asList(firstPost, secondPost);
    }

    @GetMapping("/{id}")
    public PostResponse getItem(@PathVariable Long id) {
        return PostResponse.builder()
                .title("게시글 제목")
                .description("게시글 내용")
                .imageUrl("https://imageUrl.com")
                .build();
    }
}
