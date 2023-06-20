package org.toy_project.account.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("account")
public class AccountEntity {

    @Id
    @Column("idx")
    private Long id;

    @Column("account_name")
    private String accountName;

    @Column("hash_tag")
    private String hashTag;

    @Column("youtube_url")
    private String youtubeUrl;

    @Column("post_count")
    private int postCount;

    @Column("follow_count")
    private int followCount;

    @Column("follower_count")
    private int followerCount;

    @Transient
    private AccountImageEntity accountImageEntity;
}
