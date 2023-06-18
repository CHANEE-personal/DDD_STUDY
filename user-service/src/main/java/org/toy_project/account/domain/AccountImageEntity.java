package org.toy_project.account.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("account_image")
public class AccountImageEntity {

    @Id
    @Column("idx")
    private Long id;

    @Column("type")
    private String type;

    @Column("image_url")
    private String imageUrl;

    @Column("visible")
    private boolean visible;

    @Column("account_idx")
    private Long accountId;
}
