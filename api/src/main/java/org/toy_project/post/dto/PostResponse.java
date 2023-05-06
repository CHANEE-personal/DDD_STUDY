package org.toy_project.post.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponse {

    private Long id;
    private String title;
    private String description;

    private String imageUrl;

    private int favoriteCount;
    private int replyCount;
}
