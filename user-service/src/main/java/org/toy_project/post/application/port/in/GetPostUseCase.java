package org.toy_project.post.application.port.in;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;
import org.toy_project.post.adapter.out.persistence.Post;
import reactor.core.publisher.Mono;

@Component
public interface GetPostUseCase {

    List<Post> getPostList();

    Mono<Post> getPost(Long id) throws ExecutionException, InterruptedException;
}
