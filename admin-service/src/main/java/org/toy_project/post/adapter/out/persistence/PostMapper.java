package org.toy_project.post.adapter.out.persistence;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import org.toy_project.post.domain.PostEntity;

@Component
@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "postImages", target = "postImages")
    List<Post> toPosts(List<PostEntity> postLists);

    @Mapping(source = "replies", target = "replies")
    @Mapping(source = "postImages", target = "postImages")
    Post toPost(PostEntity postEntity);
}
