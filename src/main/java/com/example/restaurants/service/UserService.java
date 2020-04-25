package com.example.restaurants.service;

import com.example.restaurants.dao.UserRepository;
import com.example.restaurants.exceptions.UserNotFoundException;
import com.example.restaurants.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findOne(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    public User saveAndFlush(User user){
        return userRepository.saveAndFlush(user);
    }

}
