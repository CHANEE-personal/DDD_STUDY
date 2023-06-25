package org.toy_project.follow.application.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.toy_project.follow.adapter.out.persistence.Follow;
import org.toy_project.follow.application.port.out.LoadFollowPort;

@ExtendWith(MockitoExtension.class)
class FollowServiceTest {

    @InjectMocks
    private FollowService followService;

    @Mock
    private LoadFollowPort loadFollowPort;


    @Test
    @DisplayName("팔로우 조회")
    void getFollowTest() {
        Follow follow = new Follow();
        follow.setId(1L);
        follow.setFollowName("ROSE");
        follow.setAllow(true);

        given(loadFollowPort.getFollow(1L)).willReturn(follow);
        Follow getFollow = followService.getFollow(1L);

        Assertions.assertThat(getFollow.getId()).isEqualTo(1L);
        Assertions.assertThat(getFollow.getFollowName()).isEqualTo("ROSE");
    }
}
