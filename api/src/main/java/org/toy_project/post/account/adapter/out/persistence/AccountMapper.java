package org.toy_project.post.account.adapter.out.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import org.toy_project.post.account.domain.AccountEntity;

@Component
@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(source = "accountImageEntity", target = "accountImage")
    Account toAccount(AccountEntity accountEntity);
}
