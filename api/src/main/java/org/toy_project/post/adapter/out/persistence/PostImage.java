package org.toy_project.post.adapter.out.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostImage {

    private Long id;
    private String name;
    private String url;
    private Integer sortNo;

    private Post post;
}
