package org.toy_project.follow.application.port.in;

import org.toy_project.follow.adapter.out.persistence.Follow;

public interface GetFollowUseCase {

    Follow getFollow(Long id);
}
