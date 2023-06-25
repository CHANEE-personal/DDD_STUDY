package org.toy_project.follow.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;
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
import org.toy_project.account.domain.AccountEntity;
import org.toy_project.account.domain.AccountImageEntity;
import org.toy_project.follow.domain.FollowEntity;

@ExtendWith(MockitoExtension.class)
class FollowPersistenceAdapterTest {

    @InjectMocks
    private FollowPersistenceAdapter followPersistenceAdapter;

    @Mock
    private FollowRepository followRepository;

    @Spy
    private FollowMapper followMapper = Mappers.getMapper(FollowMapper.class);


    @Test
    @DisplayName("내가 팔로우한 리스트 조회")
    void getFollowListTest() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(1L);
        accountEntity.setAccountName("jennierubyjane");

        AccountImageEntity accountImage = new AccountImageEntity();
        accountImage.setId(1L);
        accountImage.setType("profile");
        accountImage.setImageUrl(
                "https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-19/71533411_449636125903525_7464596574253875200_n.jpg?stp=dst-jpg_s320x320&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=46Hei6zgefcAX_ZYID0&edm=AOQ1c0wBAAAA&ccb=7-5&oh=00_AfBDTYWtogBWVxTSXTuu1-SZpHe4C9nrPXByBa98E7ljmQ&oe=645B8991&_nc_sid=8fd12b");
        accountEntity.setAccountImages(List.of(accountImage));

        Account account = new Account();
        account.setId(1L);
        account.setAccountName("jennierubyjane");

        List<FollowEntity> followEntityList = new ArrayList<>();
        FollowEntity firstFollowEntity = new FollowEntity();
        firstFollowEntity.setId(1L);
        firstFollowEntity.setFollowerName("ROSE");
        firstFollowEntity.setAllow(true);
        firstFollowEntity.setAccount(accountEntity);
        followEntityList.add(firstFollowEntity);

        FollowEntity secondFollowEntity = new FollowEntity();
        secondFollowEntity.setId(2L);
        secondFollowEntity.setFollowerName("JISU");
        secondFollowEntity.setAllow(false);
        secondFollowEntity.setAccount(accountEntity);
        followEntityList.add(secondFollowEntity);
        accountEntity.setFollowList(followEntityList);

        List<Follow> followList = new ArrayList<>();
        Follow firstFollow = new Follow();
        firstFollow.setId(1L);
        firstFollow.setFollowName("ROSE");
        firstFollow.setAllow(true);
        firstFollow.setAccount(account);
        followList.add(firstFollow);

        Follow secondFollow = new Follow();
        secondFollow.setId(2L);
        secondFollow.setFollowName("JISU");
        secondFollow.setAllow(false);
        secondFollow.setAccount(account);
        followList.add(secondFollow);

        given(followMapper.toFollows(followEntityList)).willReturn(followList);
        given(followRepository.findFollowEntityByAccountId(1L)).willReturn(followEntityList);

        List<Follow> getFollowList = followPersistenceAdapter.getFollowList(1L);
        Assertions.assertThat(getFollowList.get(0).getFollowName()).isEqualTo("ROSE");
        Assertions.assertThat(getFollowList.get(1).getFollowName()).isEqualTo("JISU");
    }


    @Test
    @DisplayName("내 계정을 팔로우한 리스트 조회")
    void getFollowerListTest() {

    }


    @Test
    @DisplayName("팔로우 계정 상세 조회")
    void getFollowTest() {

    }
}
