package com.example.restaurants.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.restaurants.model.User;
import com.example.restaurants.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuery implements GraphQLQueryResolver {

    private final UserService userService;

    public UserQuery(UserService userService) {
        this.userService = userService;
    }

    public List<User> getUsers(){
        return userService.findAll();
    }

    public User getUser(Long id){
        return userService.findOne(id);
    }

}
