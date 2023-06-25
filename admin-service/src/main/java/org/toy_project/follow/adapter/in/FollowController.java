package org.toy_project.follow.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toy_project.follow.adapter.out.persistence.Follow;
import org.toy_project.follow.application.port.in.GetFollowUseCase;
import org.toy_project.response.ApiResponse;

@RestController
@RequestMapping("/follow")
@RequiredArgsConstructor
public class FollowController {

    private final GetFollowUseCase getFollowUseCase;


    @GetMapping("/{followId}")
    public ApiResponse<Follow> getFollow(@PathVariable Long followId) {
        return ApiResponse.ok(getFollowUseCase.getFollow(followId));
    }
}
