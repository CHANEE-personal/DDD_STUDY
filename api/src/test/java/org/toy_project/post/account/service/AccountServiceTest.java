package org.toy_project.post.account.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.toy_project.post.account.dto.AccountResponse;

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
        AccountResponse accountResponse = AccountResponse.builder()
                .id(1L)
                .accountName("jennierubyjane")
                .postCount(89)
                .followCount(0)
                .followerCount(999)
                .accountImage(AccountResponse.AccountImage.builder()
                        .id(1L)
                        .type("profile")
                        .imageUrl("https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-19/71533411_449636125903525_7464596574253875200_n.jpg?stp=dst-jpg_s320x320&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=46Hei6zgefcAX_ZYID0&edm=AOQ1c0wBAAAA&ccb=7-5&oh=00_AfBDTYWtogBWVxTSXTuu1-SZpHe4C9nrPXByBa98E7ljmQ&oe=645B8991&_nc_sid=8fd12b")
                        .build())
                .hashTag("@lesyeuxdenini")
                .youtubeUrl("https://youtu.be/JyBd-qPKqpU")
                .build();

        // when
        given(accountService.getAccount(1L)).willReturn(accountResponse);
        AccountResponse account = accountService.getAccount(1L);

        // then
        assertThat(account.getId()).isEqualTo(1L);
        assertThat(account.getAccountName()).isEqualTo("jennierubyjane");
        assertThat(account.getFollowCount()).isEqualTo(999);
    }
}
