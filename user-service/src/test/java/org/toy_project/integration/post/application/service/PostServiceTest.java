package org.toy_project.integration.post.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.toy_project.post.adapter.out.persistence.Post;
import org.toy_project.post.application.port.in.GetPostUseCase;

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
class PostServiceTest {

//    private final GetPostUseCase getPostUseCase;
//
//
//    @Test
//    @DisplayName("게시글 리스트 조회")
//    void getPostListTest() {
//        List<Post> postList = getPostUseCase.getPostList();
//        Assertions.assertThat(postList.get(0).getTitle()).isNotEmpty();
//    }
//
//
//    @Test
//    @DisplayName("게시글 조회")
//    void getPostTest() {
//        Post post = getPostUseCase.getPost(1L);
//        Assertions.assertThat(post).isNotNull();
//        Assertions.assertThat(post.getPostImages()).isNotNull();
//    }
}
