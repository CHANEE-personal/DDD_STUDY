package org.toy_project.post.account.adapter.out.persistence;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.toy_project.post.account.domain.AccountEntity;

@Component
@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account toAccount(AccountEntity accountEntity);
}
