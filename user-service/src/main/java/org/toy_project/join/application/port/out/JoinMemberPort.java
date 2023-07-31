package org.toy_project.join.application.port.out;

import java.lang.reflect.Member;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public interface JoinMemberPort {

    Mono<Member> saveAccount(Member member);
}
