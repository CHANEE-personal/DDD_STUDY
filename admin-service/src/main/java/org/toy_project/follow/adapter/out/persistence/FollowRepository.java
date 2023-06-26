package org.toy_project.follow.adapter.out.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.toy_project.follow.domain.FollowEntity;

@Repository
public interface FollowRepository extends JpaRepository<FollowEntity, Long> {

    List<FollowEntity> findFollowEntitiesByAccountId(Long accountId);
}
