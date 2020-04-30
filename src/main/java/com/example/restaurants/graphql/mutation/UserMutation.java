package com.example.restaurants.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.restaurants.model.User;
import com.example.restaurants.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserMutation implements GraphQLMutationResolver {

    private final UserService userService;

    public UserMutation(UserService userService) {
        this.userService = userService;
    }

    public User registerUser(User user){
        return userService.registerUser(user);
    }

}
