package com.example.restaurants.service;

import com.example.restaurants.dao.RoleRepository;
import com.example.restaurants.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {

    private final RoleRepository roleRepository;

    public AuthorityService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findByUsersId(Long id){
        return roleRepository.findByUsersId(id);
    }

}
