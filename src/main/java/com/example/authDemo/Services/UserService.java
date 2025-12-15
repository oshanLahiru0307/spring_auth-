package com.example.authDemo.Services;

import com.example.authDemo.Entity.UserEntity;
import com.example.authDemo.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    // Dependency Injection of UserRepository
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // injecting UserRepository via constructor
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Method to create a new user
    public UserEntity createUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


}
