package org.toy_project.post.account.adapter.out.persistence;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Account {

    private Long id;
    private String accountName;

    private AccountImage accountImage;

    private String hashTag;
    private String youtubeUrl;

    private int postCount;

    private int followCount;
    private int followerCount;
}
