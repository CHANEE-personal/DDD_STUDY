package org.toy_project.integration.post.account.service;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.toy_project.post.account.model.Account;
import org.toy_project.post.account.service.AccountService;

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
@Transactional
class AccountServiceTest {

    private final AccountService accountService;

    @Test
    @DisplayName("계정 불러오기")
    void getAccountTest() {
        Account account = accountService.getAccount(1L);
        Assertions.assertThat(account.getAccountName()).isEqualTo("jennierubyjane");
    }
}
