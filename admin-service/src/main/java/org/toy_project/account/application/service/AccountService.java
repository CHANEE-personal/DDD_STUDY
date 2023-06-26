package org.toy_project.account.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.toy_project.account.adapter.out.persistence.Account;
import org.toy_project.account.application.port.in.GetAccountUseCase;
import org.toy_project.account.application.port.out.LoadAccountPort;
import org.toy_project.follow.adapter.out.persistence.Follow;
import org.toy_project.follow.adapter.out.persistence.Follower;
import org.toy_project.follow.application.port.out.LoadFollowPort;

@Service
@RequiredArgsConstructor
public class AccountService implements GetAccountUseCase {

    private final LoadAccountPort loadAccountPort;
    private final LoadFollowPort loadFollowPort;


    @Override
    public Account getAccount(Long id) {
        return loadAccountPort.loadAccount(id);
    }


    @Override
    public List<Follow> getFollowList(Long id) {
        return loadFollowPort.getFollowList(id);
    }


    @Override
    public List<Follower> getFollowerList(Long id) {
        return loadFollowPort.getFollowerList(id);
    }
}
