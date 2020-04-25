package com.example.restaurants.dao;

import com.example.restaurants.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
