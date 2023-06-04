package org.toy_project.post.account.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.toy_project.post.account.adapter.out.persistence.Account;
import org.toy_project.post.account.application.port.in.GetAccountUseCase;
import org.toy_project.post.account.application.port.out.LoadAccountPort;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AccountService implements GetAccountUseCase {

    private final LoadAccountPort loadAccountPort;


    @Override
    public Account getAccount(Long id) {
        return loadAccountPort.loadAccount(id);
    }
}
