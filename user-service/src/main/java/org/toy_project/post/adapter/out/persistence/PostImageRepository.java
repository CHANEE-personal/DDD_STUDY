package org.toy_project.post.adapter.out.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.toy_project.post.domain.PostImageEntity;
import reactor.core.publisher.Flux;

@Repository
public interface PostImageRepository extends ReactiveCrudRepository<PostImageEntity, Long> {

    Flux<PostImageEntity> findPostImageEntitiesByPostIdx(Long postId);
}
