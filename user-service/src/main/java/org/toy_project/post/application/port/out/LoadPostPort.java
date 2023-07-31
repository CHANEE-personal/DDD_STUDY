package org.toy_project.post.application.port.out;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;
import org.toy_project.post.adapter.out.persistence.Post;

@Component
public interface LoadPostPort {

    List<Post> loadPostList();

    Post loadPost(Long id) throws ExecutionException, InterruptedException;
}
