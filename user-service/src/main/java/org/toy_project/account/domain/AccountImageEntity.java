package org.toy_project.account.domain;

import io.r2dbc.spi.Clob;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
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
    private int visible;

    @Column("account_id")
    private Long accountId;

    @Transient
    private AccountEntity accountEntity;
}
