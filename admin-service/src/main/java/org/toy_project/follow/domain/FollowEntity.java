package org.toy_project.follow.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static javax.persistence.CascadeType.ALL;
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

    @Column(name = "follower_name")
    private String followerName;

//    @OneToMany(mappedBy = "following", cascade = ALL, orphanRemoval = true)
//    private List<FollowerEntity> followers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(columnDefinition = "account_idx", referencedColumnName = "idx")
    private AccountEntity account;

    @Column(name = "allow")
    private boolean allow;
}
