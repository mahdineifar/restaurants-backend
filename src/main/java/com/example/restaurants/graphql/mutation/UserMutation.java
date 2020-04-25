package com.example.restaurants.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.restaurants.model.User;
import com.example.restaurants.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public User createUser(User user){
        return userService.saveAndFlush(user);
    }

}
