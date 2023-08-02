package org.toy_project.member.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.toy_project.member.application.port.out.JoinMemberPort;
import org.toy_project.member.domain.MemberEntity;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JoinMemberPersistenceAdapter implements JoinMemberPort {

    private final JoinMemberRepository joinMemberRepository;
    private final MemberMapper memberMapper;


    @Override
    public Mono<Member> joinMember(MemberEntity memberEntity) {
        Mono<MemberEntity> memberMono = joinMemberRepository.save(memberEntity)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Error Save Member")));

        return Mono.from(memberMono).map(memberMapper::toMember);
    }
}
