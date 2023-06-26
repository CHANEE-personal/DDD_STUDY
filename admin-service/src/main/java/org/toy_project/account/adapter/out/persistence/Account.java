package org.toy_project.account.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.toy_project.follow.adapter.out.persistence.Follow;
import org.toy_project.follow.adapter.out.persistence.Follower;

@Getter
@Setter
@NoArgsConstructor
public class Account {

    private Long id;
    private String accountName;

    private List<AccountImage> accountImages = new ArrayList<>();

    private String hashTag;
    private String youtubeUrl;

    private int postCount;

    private int followCount;
    private int followerCount;

    private List<Follow> followList = new ArrayList<>();
    private List<Follower> followerList = new ArrayList<>();
}
