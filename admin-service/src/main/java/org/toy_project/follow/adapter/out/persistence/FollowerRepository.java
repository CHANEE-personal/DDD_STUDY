package org.toy_project.follow.adapter.out.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.toy_project.follow.domain.FollowerEntity;

@Repository
public interface FollowerRepository extends JpaRepository<FollowerEntity, Long> {

    List<FollowerEntity> findFollowerEntitiesByFollowingId(Long accountId);
}
