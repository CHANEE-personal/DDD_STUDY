package org.toy_project.account.adapter.out.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.toy_project.account.domain.AccountEntity;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<AccountEntity, Long> {
}
