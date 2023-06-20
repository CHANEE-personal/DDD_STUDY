package org.toy_project.account.adapter.out.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.toy_project.account.domain.AccountImageEntity;
import reactor.core.publisher.Mono;

@Repository
public interface AccountImageRepository extends ReactiveCrudRepository<AccountImageEntity, Long> {
    Mono<AccountImageEntity> findAccountImageEntityByAccountId(Long accountId);
}
