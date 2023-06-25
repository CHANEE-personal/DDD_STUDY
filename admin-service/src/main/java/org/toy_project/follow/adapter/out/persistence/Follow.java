package org.toy_project.follow.adapter.out.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.toy_project.account.adapter.out.persistence.Account;

@Getter
@Setter
@NoArgsConstructor
public class Follow {

    private Long id;
    private String followName;
    private Account account;
    private boolean allow;
}
