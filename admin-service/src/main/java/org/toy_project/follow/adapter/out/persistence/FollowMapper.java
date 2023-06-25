package org.toy_project.follow.adapter.out.persistence;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import org.toy_project.follow.domain.FollowEntity;
import org.toy_project.follow.domain.FollowerEntity;

@Component
@Mapper(componentModel = "spring")
public interface FollowMapper {

    @Mapping(source = "account", target = "account")
    List<Follow> toFollows(List<FollowEntity> followEntityList);

    @Mapping(source = "account", target = "account")
    List<Follower> toFollowers(List<FollowerEntity> followerEntityList);

    @Mapping(source = "account", target = "account")
    Follow toFollow(FollowEntity followEntity);
}
