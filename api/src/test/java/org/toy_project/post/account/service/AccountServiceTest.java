package org.toy_project.post.account.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.toy_project.post.account.model.Account;
import org.toy_project.post.account.model.AccountImage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountService accountService;

    @Test
    @DisplayName("계정 불러오기")
    void getAccountTest() {
        // given
        AccountImage accountImage = new AccountImage();
                accountImage.setId(1L);
                accountImage.setType("profile");
                accountImage.setImageUrl("https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-19/71533411_449636125903525_7464596574253875200_n.jpg?stp=dst-jpg_s320x320&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=46Hei6zgefcAX_ZYID0&edm=AOQ1c0wBAAAA&ccb=7-5&oh=00_AfBDTYWtogBWVxTSXTuu1-SZpHe4C9nrPXByBa98E7ljmQ&oe=645B8991&_nc_sid=8fd12b");

        Account account = new Account();
                account.setId(1L);
                account.setAccountName("jennierubyjane");
                account.setPostCount(89);
                account.setFollowCount(0);
                account.setFollowerCount(999);
                account.setAccountImage(accountImage);
                account.setHashTag("@lesyeuxdenini");
                account.setYoutubeUrl("https://youtu.be/JyBd-qPKqpU");

        // when
        given(accountService.getAccount(1L)).willReturn(account);
        Account getAccount = accountService.getAccount(1L);

        // then
        assertThat(getAccount.getId()).isEqualTo(1L);
        assertThat(getAccount.getAccountName()).isEqualTo("jennierubyjane");
        assertThat(getAccount.getFollowCount()).isZero();
        assertThat(getAccount.getFollowerCount()).isEqualTo(999);
    }
}
