package org.toy_project.post.account.adapter.out.persistence;

import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.toy_project.post.account.application.port.out.LoadAccountPort;
import org.toy_project.post.account.domain.AccountEntity;

@RequiredArgsConstructor
public class AccountPersistenceAdapter implements LoadAccountPort {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;


    @Override
    public Account loadAccount(Long id) {
        AccountEntity loadAccountEntity =
                accountRepository.findById(id).orElseThrow(() -> new NoSuchElementException("NOT FOUND ACCOUNT"));
        return accountMapper.toAccount(loadAccountEntity);
    }
}
