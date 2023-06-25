package org.toy_project.post.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

    private Long id;
    private String title;
    private String description;

    private int viewCount;
    private int favoriteCount;
    private int replyCount;

    private boolean visible;

    private List<Post> replies = new ArrayList<>();
    private List<PostImage> postImages = new ArrayList<>();
}
