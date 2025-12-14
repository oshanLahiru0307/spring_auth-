package com.example.authDemo.Services;

import com.example.authDemo.Entity.UserEntity;
import com.example.authDemo.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    // Dependency Injection of UserRepository
    private final UserRepository userRepository;

    // injecting UserRepository via constructor
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to create a new user
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }


}
