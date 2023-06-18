package org.toy_project.post.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.toy_project.post.domain.PostEntity;

@ExtendWith(MockitoExtension.class)
class PostPersistenceAdapterTest {

    @InjectMocks
    private PostPersistenceAdapter postPersistenceAdapter;

    @Mock
    private PostRepository postRepository;

    @Spy
    private PostMapper postMapper = Mappers.getMapper(PostMapper.class);


    @Test
    @DisplayName("게시글 리스트 조회")
    void loadPostListTest() {
        List<PostEntity> postEntityList = new ArrayList<>();
        PostEntity postEntity = new PostEntity();
        postEntity.setIdx(1L);
        postEntityList.add(postEntity);

//        given(postRepository.findAll()).willReturn(postEntityList);

//        List<Post> postList = postPersistenceAdapter.loadPostList();
//        Assertions.assertThat(postList).isNotNull();
    }


    @Test
    @DisplayName("게시글 조회")
    void loadPostTest() {
        PostEntity postEntity = new PostEntity();
        postEntity.setIdx(1L);

//        given(postRepository.findById(1L)).willReturn(Optional.of(postEntity));

//        Post post = postPersistenceAdapter.loadPost(1L);
//        Assertions.assertThat(post).isNotNull();
    }
}
