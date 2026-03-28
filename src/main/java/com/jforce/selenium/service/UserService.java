package com.jforce.selenium.service;

import com.jforce.selenium.entity.UserEntity;
import com.jforce.selenium.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public UserEntity getUserByRole(String role) {
        List<UserEntity> users = userRepository.findByRoleIgnoreCase(role);
        if (users == null || users.isEmpty()) {
            return null;
        }
        // Optionally return the first matching user (or apply logic if needed)
        return users.get(0);
    }
}
