package org.toy_project.member.adapter.out;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.toy_project.member.domain.MemberEntity;

@Component
@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member toMember(MemberEntity memberEntity);
}
