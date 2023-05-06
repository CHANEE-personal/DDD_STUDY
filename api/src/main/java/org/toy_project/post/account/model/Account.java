package org.toy_project.post.account.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "insta_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_name")
    private String accountName;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private AccountImage accountImage;

    @Column(name = "hash_tag")
    private String hashTag;

    @Column(name = "youtube_url")
    private String youtubeUrl;

    @Column(name = "post_count")
    private int postCount;

    @Column(name = "follow_count")
    private int followCount;

    @Column(name = "follwer_count")
    private int follwerCount;
}
