package org.toy_project.post.adapter.out.persistence;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.toy_project.post.application.port.out.LoadPostPort;
import org.toy_project.post.domain.PostEntity;

@Component
@RequiredArgsConstructor
class PostPersistenceAdapter implements LoadPostPort {

    private final PostRepository postRepository;
    private final PostMapper postMapper;


    @Override
    @Transactional(readOnly = true)
    public List<Post> loadPostList() {
        List<PostEntity> loadPostList = postRepository.findAll();
        return postMapper.toPostList(loadPostList);
    }


    @Override
    @Transactional(readOnly = true)
    public Post loadPost(Long id) {
        PostEntity loadPostEntity =
                postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("NOT FOUND POST"));
        return postMapper.toPost(loadPostEntity);
    }
}
