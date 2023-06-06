package org.toy_project.post.account.adapter.out.persistence;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountImage {

    private Long id;
    private String type;
    private String imageUrl;
}
