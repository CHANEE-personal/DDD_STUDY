package org.toy_project.post.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.toy_project.post.application.port.in.GetPostUseCase;
import org.toy_project.post.adapter.out.persistence.Post;
import org.toy_project.post.application.port.out.LoadPostPort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class PostService implements GetPostUseCase {

    private final LoadPostPort loadPostPort;


    @Override
    public List<Post> getPostList() {
        return loadPostPort.loadPostList();
    }


    @Override
    public Post getPost(Long id) {
        return loadPostPort.loadPost(id);
    }
}
