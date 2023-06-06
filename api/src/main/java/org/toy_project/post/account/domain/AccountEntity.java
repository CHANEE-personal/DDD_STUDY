package org.toy_project.post.account.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long id;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "hash_tag")
    private String hashTag;

    @Column(name = "youtube_url")
    private String youtubeUrl;

    @Column(name = "post_count")
    private int postCount;

    @Column(name = "follow_count")
    private int followCount;

    @Column(name = "follower_count")
    private int followerCount;

    @OneToOne(mappedBy = "accountEntity", fetch = FetchType.LAZY)
    private AccountImageEntity accountImageEntity;
}
