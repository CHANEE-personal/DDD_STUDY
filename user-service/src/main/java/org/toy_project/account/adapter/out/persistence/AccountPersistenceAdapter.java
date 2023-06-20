package org.toy_project.account.adapter.out.persistence;

import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.toy_project.account.application.port.out.LoadAccountPort;
import org.toy_project.account.domain.AccountEntity;
import org.toy_project.account.domain.AccountImageEntity;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
class AccountPersistenceAdapter implements LoadAccountPort {

    private final AccountRepository accountRepository;
    private final AccountImageRepository accountImageRepository;
    private final AccountMapper accountMapper;


    @Override
    public Mono<Account> loadAccount(Long id) {
        Mono<AccountEntity> accountMono = accountRepository.findByAccountId(id)
                .switchIfEmpty(Mono.error(new NoSuchElementException("Not Found Account")));

        Mono<AccountImageEntity> accountImageMono = accountImageRepository.findAccountImageEntityByAccountId(id);

        return Mono.zip(accountMono, accountImageMono).map(tuple -> {
            AccountEntity account = tuple.getT1();
            account.setAccountImageEntity(tuple.getT2());
            return accountMapper.toAccount(account);
        });
    }
}
