package com.clone.reddit.mapper;

import com.clone.reddit.dto.PostRequest;
import com.clone.reddit.dto.PostResponse;
import com.clone.reddit.model.Post;
import com.clone.reddit.model.Subreddit;
import com.clone.reddit.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "createDate", expression = "java(java.time.Instant.now())")
    Post map(PostRequest postRequest, Subreddit subreddit, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "subredditName", source = "subreddit.name")
    @Mapping(target = "userName", source = "user.username")
    PostResponse mapToDto(Post post);
}
