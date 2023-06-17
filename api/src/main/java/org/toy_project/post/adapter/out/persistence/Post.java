package org.toy_project.post.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Post {

    private Long id;
    private String title;
    private String description;

    private Integer viewCount;
    private Integer favoriteCount;
    private Integer replyCount;
    private Long parentIdx;
    private boolean visible;

    private List<PostImage> postImages = new ArrayList<>();

    private List<Post> replies = new ArrayList<>();
}
