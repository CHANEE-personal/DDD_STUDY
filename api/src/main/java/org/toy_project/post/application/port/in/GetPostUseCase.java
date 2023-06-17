package org.toy_project.post.application.port.in;

import java.util.List;
import org.springframework.stereotype.Component;
import org.toy_project.post.adapter.out.persistence.Post;

@Component
public interface GetPostUseCase {

    List<Post> getPostList();

    Post getPost(Long id);
}
