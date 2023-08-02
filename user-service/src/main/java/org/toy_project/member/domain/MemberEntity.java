package org.toy_project.member.domain;

import java.util.Objects;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("members")
public class MemberEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("user_name")
    private String userName;

    @Column("user_id")
    private String userId;

    @Column("password")
    private String password;

    @Column("user_phone")
    private String userPhone;

    @Column("sex")
    private String sex;

    @Column("birthday")
    private String birthday;

    @Column("address")
    private String address;

    @Column("email")
    private String email;


//    @Override
//    @Transient
//    public boolean isNew() {
//        boolean result = Objects.isNull(id);
//        this.id = result ? UUID.randomUUID() : this.id;
//        return result;
//    }
}
