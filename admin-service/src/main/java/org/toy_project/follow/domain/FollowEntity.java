package org.toy_project.follow.domain;

import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;
import org.toy_project.account.domain.AccountEntity;

@Getter
@Setter
@Entity
@Table(name = "follow")
public class FollowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long id;

    @Column(name = "follow_name")
    private String followName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_idx", referencedColumnName = "idx")
    private AccountEntity accountFollow;

    @Column(name = "allow")
    private boolean allow;
}
