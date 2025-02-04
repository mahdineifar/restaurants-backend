package com.example.restaurants.service;

import com.example.restaurants.dao.PostRepository;
import com.example.restaurants.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public List<Post> findByUserId(Long id){
        return postRepository.findByUserId(id);
    }

}
