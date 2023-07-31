package org.toy_project.join.application.port.in;

import java.lang.reflect.Member;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public interface JoinMemberUseCase {

    Mono<Member> saveMember(Member member);
}
