package org.toy_project.post.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table("post")
public class PostEntity {

    @Id
    @Column("idx")
    private Long idx;

    @Column("title")
    private String title;

    @Column("description")
    private String description;

    @Column("view_count")
    private Integer viewCount;

    @Column("favorite_count")
    private Integer favoriteCount;

    @Column("reply_count")
    private Integer replyCount;

    @Column("parent_idx")
    private Long parentIdx;

    @Column("visible")
    private boolean visible;

    @Transient
    private List<PostImageEntity> postImages = new ArrayList<>();
}
