package org.toy_project.member.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toy_project.member.adapter.out.Member;
import org.toy_project.member.application.port.in.JoinMemberUseCase;
import org.toy_project.member.domain.MemberEntity;
import org.toy_project.response.ApiResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinMemberUseCase joinMemberUseCase;


    @PostMapping
    public ApiResponse<Member> joinMember(@RequestBody MemberEntity memberEntity) {
        Mono<Member> memberMono = joinMemberUseCase.joinMember(memberEntity);
        return ApiResponse.ok(memberMono.block());
    }
}
