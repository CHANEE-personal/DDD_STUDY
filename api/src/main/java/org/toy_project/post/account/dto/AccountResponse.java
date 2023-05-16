package org.toy_project.post.account.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountResponse {

    private Long id;
    private String accountName;

    private AccountImage accountImage;

    private String hashTag;
    private String youtubeUrl;

    private int postCount;

    private int followCount;
    private int followerCount;

    @Getter
    @Builder
    public static class AccountImage {
        private Long id;
        private String type;
        private String imageUrl;
    }
}
