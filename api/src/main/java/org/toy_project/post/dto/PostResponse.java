package org.toy_project.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostResponse {

    String title;
    String description;
    String imageUrl;
}
