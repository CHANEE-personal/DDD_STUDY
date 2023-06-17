package org.toy_project.account.adapter.out.persistence;

import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.toy_project.account.application.port.out.LoadAccountPort;
import org.toy_project.account.domain.AccountEntity;

@Component
@RequiredArgsConstructor
class AccountPersistenceAdapter implements LoadAccountPort {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;


    @Override
    public Account loadAccount(Long id) {
        AccountEntity loadAccountEntity =
                accountRepository.findById(id).orElseThrow(() -> new NoSuchElementException("NOT FOUND ACCOUNT"));
        return accountMapper.toAccount(loadAccountEntity);
    }
}
