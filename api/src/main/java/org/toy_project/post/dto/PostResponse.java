package org.toy_project.post.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostResponse {

    private Long id;
    private String title;
    private String description;

    private String imageUrl;

    private int favoriteCount;
    private int replyCount;

    private List<PostReply> replyList;

    @Getter
    @Builder
    public static class PostReply {

        private Long id;
        private Long accountId;
        private String accountName;
        private String description;
        private int favoriteCount;
    }
}
