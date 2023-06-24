package org.toy_project.account.adapter.out.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import org.toy_project.account.domain.AccountEntity;

@Component
@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(source = "accountImages", target = "accountImages")
    Account toAccount(AccountEntity accountEntity);
}
