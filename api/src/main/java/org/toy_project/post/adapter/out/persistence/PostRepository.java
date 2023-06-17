package org.toy_project.post.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.toy_project.post.domain.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
