package org.toy_project.member.application.port.in;

import org.springframework.stereotype.Component;
import org.toy_project.member.adapter.out.Member;
import org.toy_project.member.domain.MemberEntity;
import reactor.core.publisher.Mono;

@Component
public interface JoinMemberUseCase {

    Mono<Member> joinMember(MemberEntity memberEntity);
}
