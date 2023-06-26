package org.toy_project.follow.application.port.out;

import java.util.List;
import org.springframework.stereotype.Component;
import org.toy_project.follow.adapter.out.persistence.Follow;
import org.toy_project.follow.adapter.out.persistence.Follower;

@Component
public interface LoadFollowPort {

    List<Follow> getFollowList(Long accountId);

    List<Follower> getFollowerList(Long accountId);

    Follow getFollow(Long id);
}
