package org.toy_project.join.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@Table("member")
public class MemberEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    @Column("user_id")
    private String userId;

    @Column("password")
    private String password;

    @Column("user_phone")
    private String userPhone;

    @Column("sex")
    private String sex;

    @Column("birthday")
    private String birthDay;

    @Column("address")
    private String address;

    @Column("email")
    private String email;
}
