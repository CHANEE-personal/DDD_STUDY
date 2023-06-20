package org.toy_project.post.adapter.out.persistence;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.toy_project.post.application.port.out.LoadPostPort;
import org.toy_project.post.domain.PostEntity;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
class PostPersistenceAdapter implements LoadPostPort {

    private final org.toy_project.post.adapter.out.persistence.PostRepository postRepository;
    private final org.toy_project.post.adapter.out.persistence.PostMapper postMapper;


    @Override
    public List<Post> loadPostList() {
        List<PostEntity> postList =
                postRepository.findAll().switchIfEmpty(Mono.error(new NoSuchElementException("Not Found Posts")))
                        .collectList().block();
        return postMapper.toPostList(postList);
    }


    @Override
    public Post loadPost(Long id) {
        PostEntity post =
                postRepository.findById(id).switchIfEmpty(Mono.error(new NoSuchElementException("Not Found Post")))
                        .block();
        return postMapper.toPost(post);
    }
}
