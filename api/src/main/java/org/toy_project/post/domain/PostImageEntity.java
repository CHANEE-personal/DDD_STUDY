package org.toy_project.post.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "post_image")
public class PostImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "sort_no")
    private Integer sortNo;

    @Column(name = "visible")
    private boolean visible;

    @ManyToOne
    @JoinColumn(name = "post_idx", referencedColumnName = "idx")
    private PostEntity postEntity;
}
