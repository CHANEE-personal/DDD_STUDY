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
import org.toy_project.post.domain.PostImageEntity;

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
    void loadPostsTest() {
        List<PostEntity> postEntityList = new ArrayList<>();
        PostEntity postEntity = new PostEntity();
        postEntity.setId(1L);
        postEntity.setTitle("test");
        postEntity.setDescription("test");

        List<PostEntity> replyEntities = new ArrayList<>();
        PostEntity replyEntity = new PostEntity();
        replyEntity.setId(2L);
        replyEntity.setParentIdx(1L);
        replyEntity.setTitle("replyTest");
        replyEntity.setDescription("replyTest");
        replyEntities.add(replyEntity);
        postEntity.setReplies(replyEntities);

        List<PostImageEntity> postImageEntities = new ArrayList<>();
        PostImageEntity postImageEntity = new PostImageEntity();
        postImageEntity.setId(1L);
        postImageEntity.setName("post");
        postImageEntity.setUrl("https://test.com");
        postImageEntities.add(postImageEntity);
        postEntity.setPostImages(postImageEntities);
        postEntityList.add(postEntity);

        List<Post> posts = new ArrayList<>();
        Post post = new Post();
        post.setId(1L);
        post.setTitle("test");
        post.setDescription("test");

        List<Post> replies = new ArrayList<>();
        Post reply = new Post();
        reply.setId(2L);
        reply.setTitle("replyTest");
        reply.setDescription("replyTest");
        replies.add(reply);
        post.setReplies(replies);

        List<PostImage> postImages = new ArrayList<>();
        PostImage postImage = new PostImage();
        postImage.setId(1L);
        postImage.setName("post");
        postImage.setUrl("https://test.com");
        postImages.add(postImage);
        post.setPostImages(postImages);
        posts.add(post);

        given(postMapper.toPosts(postEntityList)).willReturn(posts);
        given(postRepository.findAll()).willReturn(postEntityList);

        List<Post> postList = postPersistenceAdapter.loadPosts();
        Assertions.assertThat(postList.get(0).getId()).isEqualTo(1L);
        Assertions.assertThat(postList.get(0).getPostImages().get(0).getId()).isEqualTo(1L);
        Assertions.assertThat(postList.get(0).getReplies().get(0).getId()).isEqualTo(2L);
        Assertions.assertThat(postList.get(0).getReplies().get(0).getTitle()).isEqualTo("replyTest");
    }


    @Test
    @DisplayName("게시글 조회")
    void loadPostTest() {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(1L);
        postEntity.setTitle("test");
        postEntity.setDescription("test");

        List<PostEntity> replyEntities = new ArrayList<>();
        PostEntity replyEntity = new PostEntity();
        replyEntity.setId(2L);
        replyEntity.setParentIdx(1L);
        replyEntity.setTitle("replyTest");
        replyEntity.setDescription("replyTest");
        replyEntities.add(replyEntity);
        postEntity.setReplies(replyEntities);

        List<PostImageEntity> postImageEntities = new ArrayList<>();
        PostImageEntity postImageEntity = new PostImageEntity();
        postImageEntity.setId(1L);
        postImageEntity.setName("post");
        postImageEntity.setUrl("https://test.com");
        postImageEntities.add(postImageEntity);
        postEntity.setPostImages(postImageEntities);

        Post post = new Post();
        post.setId(1L);
        post.setTitle("test");
        post.setDescription("test");

        List<Post> replies = new ArrayList<>();
        Post reply = new Post();
        reply.setId(2L);
        reply.setTitle("replyTest");
        reply.setDescription("replyTest");
        replies.add(reply);
        post.setReplies(replies);

        List<PostImage> postImages = new ArrayList<>();
        PostImage postImage = new PostImage();
        postImage.setId(1L);
        postImage.setName("post");
        postImage.setUrl("https://test.com");
        postImages.add(postImage);

        post.setPostImages(postImages);

        given(postMapper.toPost(postEntity)).willReturn(post);
        given(postRepository.findById(1L)).willReturn(Optional.of(postEntity));

        Post getPost = postPersistenceAdapter.loadPost(1L);
        Assertions.assertThat(getPost.getId()).isEqualTo(1L);
        Assertions.assertThat(getPost.getPostImages().get(0).getId()).isEqualTo(1L);
        Assertions.assertThat(getPost.getReplies().get(0).getId()).isEqualTo(2L);
        Assertions.assertThat(getPost.getReplies().get(0).getTitle()).isEqualTo("replyTest");
    }
}
