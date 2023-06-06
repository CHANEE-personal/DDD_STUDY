package org.toy_project.post.account.adapter.out.persistence;

import java.util.Optional;
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
import org.toy_project.post.account.domain.AccountEntity;

@ExtendWith(MockitoExtension.class)
class AccountPersistenceAdapterTest {

    @InjectMocks
    private AccountPersistenceAdapter accountPersistenceAdapter;

    @Mock
    private AccountRepository accountRepository;

    @Spy
    private AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);


    @Test
    @DisplayName("계정 조회")
    void loadAccountTest() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(1L);
        given(accountRepository.findById(1L)).willReturn(Optional.of(accountEntity));

        Account account = accountPersistenceAdapter.loadAccount(1L);
        Assertions.assertThat(account.getId()).isEqualTo(1L);
    }
}
