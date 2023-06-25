package org.toy_project.post.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    @Lob
    private String description;

    @Column(name = "view_count")
    private int viewCount;

    @Column(name = "favorite_count")
    private int favoriteCount;

    @Column(name = "reply_count")
    private int replyCount;

    @Column(name = "visible")
    private boolean visible;

    @Column(name = "parent_idx")
    private Long parentIdx;

    @OneToMany(mappedBy = "parentIdx", cascade = CascadeType.ALL, orphanRemoval = true)
    @Where(clause = "idx != parent_idx")
    private List<PostEntity> replies = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostImageEntity> postImages = new ArrayList<>();
}
