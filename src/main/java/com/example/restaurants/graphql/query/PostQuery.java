package com.example.restaurants.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.restaurants.model.Post;
import com.example.restaurants.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostQuery implements GraphQLQueryResolver {

    private final PostService postService;

    public PostQuery(PostService postService) {
        this.postService = postService;
    }

    public List<Post> getPosts(){
        return postService.findAll();
    }

}
