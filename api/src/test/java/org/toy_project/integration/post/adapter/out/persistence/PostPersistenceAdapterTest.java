package org.toy_project.integration.post.adapter.out.persistence;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.toy_project.post.adapter.out.persistence.Post;
import org.toy_project.post.application.port.out.LoadPostPort;

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
public class PostPersistenceAdapterTest {

    private final LoadPostPort loadPostPort;


    @Test
    @DisplayName("게시글 리스트 조회")
    void loadPostListTest() {
        List<Post> postList = loadPostPort.loadPostList();
        Assertions.assertThat(postList.get(0)).isNotNull();
        Assertions.assertThat(postList.get(0).getPostImages()).isNotNull();
    }


    @Test
    @DisplayName("게시글 조회")
    void loadPostTest() {
        Post post = loadPostPort.loadPost(1L);
        Assertions.assertThat(post).isNotNull();
        Assertions.assertThat(post.getPostImages()).isNotNull();
    }
}
