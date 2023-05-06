package org.toy_project.post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toy_project.post.dto.PostResponse;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/posts/{accountId}")
public class PostController {

    @GetMapping
    public List<PostResponse> getPosts(@PathVariable Long accountId) {
        PostResponse firstPost = PostResponse.builder()
                .id(1L)
                .title("My first ever Met honoring Karl Lagerfeld with @chanelofficial. Merci mon chanel family for this dream look")
                .description("My first ever Met honoring Karl Lagerfeld with @chanelofficial. Merci mon chanel family for this dream look")
                .imageUrl("https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-15/344281307_592826875941624_3520706586042566367_n.jpg?stp=dst-jpg_e35&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=F8TuCnTHqwwAX-C-iUm&edm=ACWDqb8BAAAA&ccb=7-5&ig_cache_key=MzA5MzcwNzg0MzY4NTYxMzM1OQ%3D%3D.2-ccb7-5&oh=00_AfCrgnsqJa3AdIUjCCYrpU20610UTtUAjSD6uoxF96gWqQ&oe=645A05CA&_nc_sid=1527a3")
                .favoriteCount(989000)
                .replyCount(888999)
                .build();

        PostResponse secondPost = PostResponse.builder()
                .id(2L)
                .title("@calvinklein \uD83E\uDD8B")
                .description("@calvinklein \uD83E\uDD8B")
                .imageUrl("https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-15/343958130_148245904710363_1719180612311903351_n.jpg?stp=dst-jpg_e35&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=oPBKOfFlX7gAX_ELxXs&edm=ACWDqb8BAAAA&ccb=7-5&ig_cache_key=MzA5Mjc3MTI3MTIzODQzMTAyOA%3D%3D.2-ccb7-5&oh=00_AfCGERkrnzyEV6NilwAjPqqI5XyUhj7YWRvTbJupJmgoxQ&oe=645BBBD4&_nc_sid=1527a3")
                .favoriteCount(766900)
                .replyCount(635000)
                .build();

        return Arrays.asList(firstPost, secondPost);
    }

    @GetMapping("/{postId}")
    public PostResponse getPost(@PathVariable Long accountId, @PathVariable Long postId) {
        PostResponse.PostReply firstPostReply = PostResponse.PostReply.builder()
                .id(1L)
                .accountId(25L)
                .accountName("japi.nk")
                .description("Jennie, just keep doing what you love. We are here always supporting you no matter what. Just be who you are, cause we love you either way\uD83D\uDDA4✨ take good care of yourself. We are so proud of you \uD83D\uDDA4")
                .favoriteCount(9999)
                .build();

        PostResponse.PostReply secondReply = PostResponse.PostReply.builder()
                .id(2L)
                .accountId(999L)
                .accountName("jennierubyjanek")
                .description("JENNIE MY LOVE")
                .favoriteCount(5555)
                .build();

        return PostResponse.builder()
                .id(1L)
                .title("My first ever Met honoring Karl Lagerfeld with @chanelofficial. Merci mon chanel family for this dream look")
                .description("My first ever Met honoring Karl Lagerfeld with @chanelofficial. Merci mon chanel family for this dream look")
                .imageUrl("https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-15/344281307_592826875941624_3520706586042566367_n.jpg?stp=dst-jpg_e35&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=F8TuCnTHqwwAX-C-iUm&edm=ACWDqb8BAAAA&ccb=7-5&ig_cache_key=MzA5MzcwNzg0MzY4NTYxMzM1OQ%3D%3D.2-ccb7-5&oh=00_AfCrgnsqJa3AdIUjCCYrpU20610UTtUAjSD6uoxF96gWqQ&oe=645A05CA&_nc_sid=1527a3")
                .favoriteCount(989000)
                .replyCount(888999)
                .replyList(Arrays.asList(firstPostReply, secondReply))
                .build();
    }
}
