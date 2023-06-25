package org.toy_project.post.application.service;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.toy_project.post.adapter.out.persistence.Post;
import org.toy_project.post.adapter.out.persistence.PostImage;
import org.toy_project.post.application.port.out.LoadPostPort;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private LoadPostPort loadPostPort;


    @Test
    @DisplayName("게시글 리스트 조회")
    void getPostsTest() {
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

        given(loadPostPort.loadPosts()).willReturn(posts);

        List<Post> postList = postService.getPosts();
        Assertions.assertThat(postList.get(0).getId()).isEqualTo(1L);
        Assertions.assertThat(postList.get(0).getPostImages().get(0).getId()).isEqualTo(1L);
        Assertions.assertThat(postList.get(0).getReplies().get(0).getId()).isEqualTo(2L);
        Assertions.assertThat(postList.get(0).getReplies().get(0).getTitle()).isEqualTo("replyTest");
    }


    @Test
    @DisplayName("게시글 조회")
    void getPostTest() {
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

        given(loadPostPort.loadPost(1L)).willReturn(post);

        Post getPost = postService.getPost(1L);
        Assertions.assertThat(getPost.getId()).isEqualTo(1L);
        Assertions.assertThat(getPost.getPostImages().get(0).getId()).isEqualTo(1L);
        Assertions.assertThat(getPost.getReplies().get(0).getId()).isEqualTo(2L);
        Assertions.assertThat(getPost.getReplies().get(0).getTitle()).isEqualTo("replyTest");
    }
}
