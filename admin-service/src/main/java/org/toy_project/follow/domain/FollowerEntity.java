package org.toy_project.follow.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.toy_project.account.adapter.out.persistence.Account;
import org.toy_project.account.domain.AccountEntity;

@Getter
@Setter
@Entity
@Table(name = "follower")
public class FollowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long id;

    @Column(name = "follow_name")
    private String followName;

    @ManyToOne
    @JoinColumn(columnDefinition = "follow_idx", referencedColumnName = "idx")
    private AccountEntity account;
}
