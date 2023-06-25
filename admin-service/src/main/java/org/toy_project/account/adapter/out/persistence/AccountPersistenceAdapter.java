package org.toy_project.account.adapter.out.persistence;

import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.toy_project.account.application.port.out.LoadAccountPort;

@Component
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements LoadAccountPort {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;


    @Override
    public Account loadAccount(Long id) {

        return accountMapper.toAccount(
                accountRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not Found Account")));
    }
}
