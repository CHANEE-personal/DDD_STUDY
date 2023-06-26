package org.toy_project.account.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.toy_project.follow.domain.FollowEntity;
import org.toy_project.follow.domain.FollowerEntity;

@Getter
@Setter
@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    Long id;

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

    @Column(name = "follwer_count")
    private int followerCount;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<AccountImageEntity> accountImages = new ArrayList<>();

    @OneToMany(mappedBy = "accountFollow", fetch = FetchType.LAZY)
    private List<FollowEntity> followList = new ArrayList<>();

    @OneToMany(mappedBy = "accountFollower", fetch = FetchType.LAZY)
    private List<FollowerEntity> followerList = new ArrayList<>();
}
