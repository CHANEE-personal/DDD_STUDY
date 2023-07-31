package org.toy_project.post.adapter.out.persistence;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import org.toy_project.post.domain.PostEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "postImages", target = "postImages")
    Post toPost(PostEntity postEntity);

    List<Post> toPostList(List<PostEntity> postEntityList);
}
