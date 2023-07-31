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
@Table("post_image")
public class PostImageEntity {

    @Id
    @Column("idx")
    private Long id;

    @Column("name")
    private String name;

    @Column("url")
    private String url;

    @Column("sort_no")
    private Integer sortNo;

    @Column("post_idx")
    private Long postIdx;

    @Column("visible")
    private boolean visible;
}
