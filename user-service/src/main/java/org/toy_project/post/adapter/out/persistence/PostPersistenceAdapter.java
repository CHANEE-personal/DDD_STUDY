package org.toy_project.post.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.toy_project.post.application.port.out.LoadPostPort;
import org.toy_project.post.domain.PostEntity;
import org.toy_project.post.domain.PostImageEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
class PostPersistenceAdapter implements LoadPostPort {

    private final PostRepository postRepository;
    private final PostImageRepository postImageRepository;
    private final PostMapper postMapper;


    @Override
    public List<Post> loadPostList() {
        List<PostEntity> postList =
                postRepository.findAll().switchIfEmpty(Mono.error(new NoSuchElementException("Not Found Posts")))
                        .collectList().block();
        return postMapper.toPostList(postList);
    }


    @Override
    public Post loadPost(Long id) throws ExecutionException, InterruptedException {
        Mono<PostEntity> postMono =
                postRepository.findById(id).switchIfEmpty(Mono.error(new NoSuchElementException("Not Found Post")));

        List<PostImageEntity> postImages = new ArrayList<>();
        postImageRepository.findPostImageEntitiesByPostIdx(id)
                .switchIfEmpty(Flux.error(new NoSuchElementException("Not Found Post Images")))
                .collectList().subscribe(postImages::addAll);

        PostEntity postEntity = postMono.toFuture().get();
        postEntity.setPostImages(postImages);
        return postMapper.toPost(postEntity);
    }
}
