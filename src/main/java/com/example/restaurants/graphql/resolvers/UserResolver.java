package com.example.restaurants.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.restaurants.model.Role;
import com.example.restaurants.model.Post;
import com.example.restaurants.model.User;
import com.example.restaurants.service.AuthorityService;
import com.example.restaurants.service.PostService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserResolver implements GraphQLResolver<User> {

    private final PostService postService;
    private final AuthorityService authorityService;

    public UserResolver(PostService postService, AuthorityService authorityService) {
        this.postService = postService;
        this.authorityService = authorityService;
    }

    public List<Post> posts(User user){
        return postService.findByUserId(user.getId());
    }
    public List<Role> authorities(User user){
        return authorityService.findByUsersId(user.getId());
    }
}
