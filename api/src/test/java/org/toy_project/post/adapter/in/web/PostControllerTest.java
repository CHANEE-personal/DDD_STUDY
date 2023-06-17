package org.toy_project.post.adapter.in.web;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.toy_project.post.adapter.out.persistence.Post;
import org.toy_project.post.adapter.out.persistence.PostImage;
import org.toy_project.post.application.port.in.GetPostUseCase;

@DisplayName("게시글 관련 api")
@AutoConfigureRestDocs
@WebMvcTest(controllers = PostController.class, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE)})
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetPostUseCase getPostUseCase;


    @BeforeEach
    void init() {
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

        post.setPostImages(List.of(postImage));
        postList.add(post);

        given(getPostUseCase.getPostList()).willReturn(postList);
        given(getPostUseCase.getPost(1L)).willReturn(post);
    }


    @Test
    @DisplayName("게시글 리스트 조회")
    void getPostListTest() throws Exception {
        mockMvc.perform(get("/post")).andDo(print());
    }


    @Test
    @DisplayName("게시글 조회")
    void getPostTest() throws Exception {
        mockMvc.perform(get("/post/{postId}", 1L)).andDo(PostControllerDocs.getPostDetail()).andDo(print());
    }
}
