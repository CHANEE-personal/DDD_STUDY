package org.toy_project.post.account.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.toy_project.post.account.domain.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
