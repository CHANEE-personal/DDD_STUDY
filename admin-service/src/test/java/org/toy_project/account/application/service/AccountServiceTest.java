package org.toy_project.account.application.service;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.toy_project.account.adapter.out.persistence.Account;
import org.toy_project.account.adapter.out.persistence.AccountImage;
import org.toy_project.account.application.port.out.LoadAccountPort;
import org.toy_project.follow.adapter.out.persistence.Follow;
import org.toy_project.follow.adapter.out.persistence.Follower;
import org.toy_project.follow.application.port.out.LoadFollowPort;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private LoadAccountPort loadAccountPort;

    @Mock
    private LoadFollowPort loadFollowPort;


    @Test
    @DisplayName("계정 조회")
    void getAccountTest() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountName("jennierubyjane");

        AccountImage accountImage = new AccountImage();
        accountImage.setId(1L);
        accountImage.setType("profile");
        accountImage.setImageUrl(
                "https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-19/71533411_449636125903525_7464596574253875200_n.jpg?stp=dst-jpg_s320x320&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=46Hei6zgefcAX_ZYID0&edm=AOQ1c0wBAAAA&ccb=7-5&oh=00_AfBDTYWtogBWVxTSXTuu1-SZpHe4C9nrPXByBa98E7ljmQ&oe=645B8991&_nc_sid=8fd12b");
        account.setAccountImages(List.of(accountImage));

        given(loadAccountPort.loadAccount(1L)).willReturn(account);

        Account getAccount = accountService.getAccount(1L);
        Assertions.assertThat(getAccount.getAccountName()).isEqualTo("jennierubyjane");
    }


    @Test
    @DisplayName("내 계정이 팔로우한 리스트 조회")
    void getFollowListTest() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountName("jennierubyjane");

        AccountImage accountImage = new AccountImage();
        accountImage.setId(1L);
        accountImage.setType("profile");
        accountImage.setImageUrl(
                "https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-19/71533411_449636125903525_7464596574253875200_n.jpg?stp=dst-jpg_s320x320&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=46Hei6zgefcAX_ZYID0&edm=AOQ1c0wBAAAA&ccb=7-5&oh=00_AfBDTYWtogBWVxTSXTuu1-SZpHe4C9nrPXByBa98E7ljmQ&oe=645B8991&_nc_sid=8fd12b");
        account.setAccountImages(List.of(accountImage));

        List<Follow> followList = new ArrayList<>();
        Follow follow = new Follow();
        follow.setId(1L);
        follow.setFollowName("ROSE");
        follow.setAccountFollow(account);
        follow.setAllow(true);
        followList.add(follow);

        given(loadFollowPort.getFollowList(1L)).willReturn(followList);
        List<Follow> getFollowList = accountService.getFollowList(1L);
        Assertions.assertThat(getFollowList.get(0).getFollowName()).isEqualTo("ROSE");
    }

    @Test
    @DisplayName("내 계정을 팔로워한 리스트")
    void getFollowerListTest() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountName("jennierubyjane");

        AccountImage accountImage = new AccountImage();
        accountImage.setId(1L);
        accountImage.setType("profile");
        accountImage.setImageUrl(
                "https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-19/71533411_449636125903525_7464596574253875200_n.jpg?stp=dst-jpg_s320x320&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=46Hei6zgefcAX_ZYID0&edm=AOQ1c0wBAAAA&ccb=7-5&oh=00_AfBDTYWtogBWVxTSXTuu1-SZpHe4C9nrPXByBa98E7ljmQ&oe=645B8991&_nc_sid=8fd12b");
        account.setAccountImages(List.of(accountImage));

        List<Follower> followerList = new ArrayList<>();
        Follower firstFollower = new Follower();
        firstFollower.setId(1L);
        firstFollower.setAccountFollower(account);
        firstFollower.setFollowerName("ROSE");
        followerList.add(firstFollower);

        Follower secondFollower = new Follower();
        secondFollower.setId(2L);
        secondFollower.setAccountFollower(account);
        secondFollower.setFollowerName("JISU");
        followerList.add(secondFollower);

        given(loadFollowPort.getFollowerList(1L)).willReturn(followerList);
        List<Follower> getFollowerList = accountService.getFollowerList(1L);

        Assertions.assertThat(getFollowerList.get(0).getFollowerName()).isEqualTo("ROSE");
        Assertions.assertThat(getFollowerList.get(1).getFollowerName()).isEqualTo("JISU");
    }
}
