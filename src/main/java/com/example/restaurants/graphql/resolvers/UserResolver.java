package com.example.restaurants.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.restaurants.model.Post;
import com.example.restaurants.model.User;
import com.example.restaurants.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserResolver implements GraphQLResolver<User> {

    @Autowired
    private PostService postService;

    public List<Post> posts(User user){
        return postService.findByUserId(user.getId());
    }
}
