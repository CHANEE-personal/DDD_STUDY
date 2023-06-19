package org.toy_project.account.adapter.out.persistence;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.toy_project.account.domain.AccountEntity;
import org.toy_project.account.domain.AccountImageEntity;
import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
class AccountPersistenceAdapterTest {

    @InjectMocks
    private AccountPersistenceAdapter accountPersistenceAdapter;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountImageRepository accountImageRepository;

    @Spy
    private AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);


    @Test
    @DisplayName("계정 조회")
    void loadAccountTest() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(1L);

        AccountImageEntity accountImageEntity = new AccountImageEntity();
        accountImageEntity.setAccountId(1L);

        given(accountRepository.findByAccountId(1L)).willReturn(Mono.just(accountEntity));
        given(accountImageRepository.findAccountImageEntityByAccountId(1L)).willReturn(Mono.just(accountImageEntity));

        Account account = accountPersistenceAdapter.loadAccount(1L).block();
        Assertions.assertThat(account.getId()).isEqualTo(1L);
    }
}
