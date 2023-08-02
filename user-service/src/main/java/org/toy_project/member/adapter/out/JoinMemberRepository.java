package org.toy_project.member.adapter.out;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.toy_project.member.domain.MemberEntity;

@Repository
public interface JoinMemberRepository extends ReactiveCrudRepository<MemberEntity, Long> {}
