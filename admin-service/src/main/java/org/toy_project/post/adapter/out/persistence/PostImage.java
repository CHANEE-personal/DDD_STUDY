package org.toy_project.post.adapter.out.persistence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostImage {

    private Long id;
    private String name;
    private String url;
    private int sortNo;
    private Post post;
}
