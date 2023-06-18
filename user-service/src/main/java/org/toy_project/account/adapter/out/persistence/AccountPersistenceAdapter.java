package org.toy_project.account.adapter.out.persistence;

import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.toy_project.account.application.port.out.LoadAccountPort;
import org.toy_project.account.domain.AccountEntity;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
class AccountPersistenceAdapter implements LoadAccountPort {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;


    @Override
    public Account loadAccount(Long id) {
        AccountEntity account = accountRepository.findById(id)
                .switchIfEmpty(Mono.error(new NoSuchElementException("Not Found Account"))).block();
        return accountMapper.toAccount(account);
    }
}
