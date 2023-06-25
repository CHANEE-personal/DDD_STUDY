package org.toy_project.follow.adapter.out.persistence;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.toy_project.follow.application.port.out.LoadFollowPort;
import org.toy_project.follow.domain.FollowEntity;
import org.toy_project.follow.domain.FollowerEntity;

@Component
@RequiredArgsConstructor
class FollowPersistenceAdapter implements LoadFollowPort {

    private final FollowRepository followRepository;
    private final FollowerRepository followerRepository;
    private final FollowMapper followMapper;


    @Override
    public List<Follow> getFollowList(Long accountId) {
        List<FollowEntity> followList = followRepository.findFollowEntityByAccountId(accountId);
        return followMapper.toFollows(followList);
    }


    @Override
    public List<Follower> getFollowerList(Long accountId) {
//        List<FollowerEntity> follwerList = followerRepository.findFollowerEntitiesByFollowingId(accountId);
//        return followMapper.toFollowers(follwerList);
        return null;
    }


    @Override
    public Follow getFollow(Long id) {
//        FollowEntity follow =
//                followRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not Found Follow"));
//        return followMapper.toFollow(follow);
        return null;
    }
}
