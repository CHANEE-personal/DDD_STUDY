package org.toy_project.join.application.service;

import java.lang.reflect.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.toy_project.join.application.port.in.JoinMemberUseCase;
import org.toy_project.join.application.port.out.JoinMemberPort;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class MemberJoinService implements JoinMemberUseCase {

    private final JoinMemberPort joinMemberPort;

    public Mono<Member> saveMember(Member member) {
        return joinMemberPort.saveAccount(member);
    }
}
