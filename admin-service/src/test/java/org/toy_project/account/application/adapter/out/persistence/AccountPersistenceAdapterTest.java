package org.toy_project.account.application.adapter.out.persistence;

import java.util.List;
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
import org.toy_project.account.adapter.out.persistence.Account;
import org.toy_project.account.adapter.out.persistence.AccountImage;
import org.toy_project.account.adapter.out.persistence.AccountMapper;
import org.toy_project.account.adapter.out.persistence.AccountPersistenceAdapter;
import org.toy_project.account.adapter.out.persistence.AccountRepository;
import org.toy_project.account.domain.AccountEntity;
import org.toy_project.account.domain.AccountImageEntity;

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

        AccountImageEntity accountImageEntity = new AccountImageEntity();
        accountImageEntity.setId(1L);
        accountImageEntity.setType("profile");

        accountEntity.setAccountImages(List.of(accountImageEntity));

        Account account = new Account();
        account.setId(1L);

        AccountImage accountImage = new AccountImage();
        accountImage.setId(1L);
        accountImage.setType("profile");

        account.setAccountImages(List.of(accountImage));

        given(accountMapper.toAccount(accountEntity)).willReturn(account);
        given(accountRepository.findById(1L)).willReturn(Optional.of(accountEntity));

        Account getAccount = accountPersistenceAdapter.loadAccount(1L);
        Assertions.assertThat(getAccount.getId()).isEqualTo(1L);
    }
}
