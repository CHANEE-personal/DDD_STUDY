package org.toy_project.member.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.toy_project.member.adapter.out.Member;
import org.toy_project.member.application.port.in.JoinMemberUseCase;
import org.toy_project.member.application.port.out.JoinMemberPort;
import org.toy_project.member.domain.MemberEntity;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
class JoinMemberService implements JoinMemberUseCase {

    private final JoinMemberPort joinMemberPort;


    @Override
    public Mono<Member> joinMember(MemberEntity memberEntity) {
        return joinMemberPort.joinMember(memberEntity);
    }
}
