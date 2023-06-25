package org.toy_project.account.application.port.in;

import java.util.List;
import org.springframework.stereotype.Component;
import org.toy_project.account.adapter.out.persistence.Account;
import org.toy_project.follow.adapter.out.persistence.Follow;
import org.toy_project.follow.adapter.out.persistence.Follower;

@Component
public interface GetAccountUseCase {

    Account getAccount(Long id);

    List<Follow> getFollowList(Long id);

    List<Follower> getFollowerList(Long id);
}
