package org.toy_project.follow.adapter.out.persistence;

import lombok.Getter;
import lombok.Setter;
import org.toy_project.account.adapter.out.persistence.Account;

@Getter
@Setter
public class Follower {

    private Long id;
    private String followerName;
    private Account accountFollower;
}
