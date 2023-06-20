package org.toy_project.account.adapter.out.persistence;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.toy_project.account.domain.AccountEntity;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<AccountEntity, Long> {

    @Query("select * from account left join account_image on account.idx = account_image.account_id "
            + "where account_image.account_id = :accountId")
    Mono<AccountEntity> findByAccountId(@Param("areaId") Long accountId);
}
