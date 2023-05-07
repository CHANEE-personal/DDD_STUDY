package org.toy_project.post.account.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "account")
public class Account {

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

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private AccountImage accountImage;
}
