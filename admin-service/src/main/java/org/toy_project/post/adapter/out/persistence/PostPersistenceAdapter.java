package org.toy_project.post.adapter.out.persistence;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.toy_project.post.application.port.out.LoadPostPort;
import org.toy_project.post.domain.PostEntity;

@RequiredArgsConstructor
class PostPersistenceAdapter implements LoadPostPort {

    private final PostRepository postRepository;
    private final PostMapper postMapper;


    @Override
    public List<Post> loadPosts() {
        List<PostEntity> posts = postRepository.findAll();
        return postMapper.toPosts(posts);
    }


    @Override
    public Post loadPost(Long id) {
        PostEntity post = postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not Found Post"));
        return postMapper.toPost(post);
    }
}
