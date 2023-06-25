package org.toy_project.account.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.toy_project.account.adapter.out.persistence.Account;
import org.toy_project.account.application.port.in.GetAccountUseCase;
import org.toy_project.account.application.port.out.LoadAccountPort;

@Service
@RequiredArgsConstructor
public class AccountService implements GetAccountUseCase {

    private final LoadAccountPort loadAccountPort;


    @Override
    public Account getAccount(Long id) {
        return loadAccountPort.loadAccount(id);
    }
}
