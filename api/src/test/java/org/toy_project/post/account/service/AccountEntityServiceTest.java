package org.toy_project.post.account.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.toy_project.post.account.application.service.AccountService;
import org.toy_project.post.account.domain.AccountEntity;
import org.toy_project.post.account.domain.AccountImageEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AccountEntityServiceTest {

    @Mock
    private AccountService accountService;

    @Test
    @DisplayName("계정 불러오기")
    void getAccountTest() {
        // given
        AccountImageEntity accountImageEntity = new AccountImageEntity();
                accountImageEntity.setId(1L);
                accountImageEntity.setType("profile");
                accountImageEntity.setImageUrl("https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-19/71533411_449636125903525_7464596574253875200_n.jpg?stp=dst-jpg_s320x320&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=46Hei6zgefcAX_ZYID0&edm=AOQ1c0wBAAAA&ccb=7-5&oh=00_AfBDTYWtogBWVxTSXTuu1-SZpHe4C9nrPXByBa98E7ljmQ&oe=645B8991&_nc_sid=8fd12b");

        AccountEntity accountEntity = new AccountEntity();
                accountEntity.setId(1L);
                accountEntity.setAccountName("jennierubyjane");
                accountEntity.setPostCount(89);
                accountEntity.setFollowCount(0);
                accountEntity.setFollowerCount(999);
                accountEntity.setAccountImageEntity(accountImageEntity);
                accountEntity.setHashTag("@lesyeuxdenini");
                accountEntity.setYoutubeUrl("https://youtu.be/JyBd-qPKqpU");

        // when
        given(accountService.getAccount(1L)).willReturn(accountEntity);
        AccountEntity getAccountEntity = accountService.getAccount(1L);

        // then
        assertThat(getAccountEntity.getId()).isEqualTo(1L);
        assertThat(getAccountEntity.getAccountName()).isEqualTo("jennierubyjane");
        assertThat(getAccountEntity.getFollowCount()).isZero();
        assertThat(getAccountEntity.getFollowerCount()).isEqualTo(999);
    }
}
