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
    void getPostListTest() {
        List<Post> postList = new ArrayList<>();
        Post post = new Post();
        post.setId(1L);
        post.setTitle(
                "My first ever Met honoring Karl Lagerfeld with @chanelofficial. Merci mon chanel family for this dream look");
        post.setDescription(
                "My first ever Met honoring Karl Lagerfeld with @chanelofficial. Merci mon chanel family for this dream look");
        post.setViewCount(989000);
        post.setFavoriteCount(989000);
        post.setReplyCount(10000);
        post.setVisible(true);

        PostImage postImage = new PostImage();
        postImage.setId(1L);
        postImage.setName("image");
        postImage.setUrl(
                "https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-15/344281307_592826875941624_3520706586042566367_n.jpg?stp=dst-jpg_e35&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=F8TuCnTHqwwAX-C-iUm&edm=ACWDqb8BAAAA&ccb=7-5&ig_cache_key=MzA5MzcwNzg0MzY4NTYxMzM1OQ%3D%3D.2-ccb7-5&oh=00_AfCrgnsqJa3AdIUjCCYrpU20610UTtUAjSD6uoxF96gWqQ&oe=645A05CA&_nc_sid=1527a3");
        postImage.setSortNo(1);
        postImage.setPost(post);

        post.setPostImages(List.of(postImage));
        postList.add(post);

        given(loadPostPort.loadPostList()).willReturn(postList);

        List<Post> getPostList = postService.getPostList();
        Assertions.assertThat(getPostList).isNotNull();
        Assertions.assertThat(getPostList.get(0).getPostImages()).isNotNull();
    }

    @Test
    @DisplayName("게시글 조회")
    void getPostTest() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle(
                "My first ever Met honoring Karl Lagerfeld with @chanelofficial. Merci mon chanel family for this dream look");
        post.setDescription(
                "My first ever Met honoring Karl Lagerfeld with @chanelofficial. Merci mon chanel family for this dream look");
        post.setViewCount(989000);
        post.setFavoriteCount(989000);
        post.setReplyCount(10000);
        post.setVisible(true);

        PostImage postImage = new PostImage();
        postImage.setId(1L);
        postImage.setName("image");
        postImage.setUrl(
                "https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-15/344281307_592826875941624_3520706586042566367_n.jpg?stp=dst-jpg_e35&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=F8TuCnTHqwwAX-C-iUm&edm=ACWDqb8BAAAA&ccb=7-5&ig_cache_key=MzA5MzcwNzg0MzY4NTYxMzM1OQ%3D%3D.2-ccb7-5&oh=00_AfCrgnsqJa3AdIUjCCYrpU20610UTtUAjSD6uoxF96gWqQ&oe=645A05CA&_nc_sid=1527a3");
        postImage.setSortNo(1);
        postImage.setPost(post);

        post.setPostImages(List.of(postImage));

        given(loadPostPort.loadPost(1L)).willReturn(post);

        Post getPost = postService.getPost(1L);
        Assertions.assertThat(getPost).isNotNull();
        Assertions.assertThat(getPost.getPostImages()).isNotNull();
    }
}
