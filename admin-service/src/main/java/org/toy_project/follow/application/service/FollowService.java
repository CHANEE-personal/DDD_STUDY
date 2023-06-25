package org.toy_project.follow.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.toy_project.follow.adapter.out.persistence.Follow;
import org.toy_project.follow.application.port.in.GetFollowUseCase;
import org.toy_project.follow.application.port.out.LoadFollowPort;

@Service
@RequiredArgsConstructor
class FollowService implements GetFollowUseCase {

    private final LoadFollowPort loadFollowPort;


    @Override
    public Follow getFollow(Long id) {
        return loadFollowPort.getFollow(id);
    }
}
