package com.example.restaurants.dao;

import com.example.restaurants.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByUsersId(Long id);
    Optional<Role> findByName(String name);
}
