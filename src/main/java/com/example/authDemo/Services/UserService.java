package com.example.authDemo.Services;

import com.example.authDemo.DTO.LoginRequestDTO;
import com.example.authDemo.DTO.LoginResponseDTO;
import com.example.authDemo.Entity.UserEntity;
import com.example.authDemo.Repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserService {

    // Dependency Injection of UserRepository
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    // injecting UserRepository via constructor
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    // Method to create a new user
    public UserEntity createUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Method to log in a user
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequestDTO.getUsername(),
                    loginRequestDTO.getPassword()
            ));
        }catch (Exception e){
            return new LoginResponseDTO(null, null, "Invalid username or password", "login_failed");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "USER"); // Example claim
        claims.put("email", "sample@gmail.com");

        String token = jwtService.getJwtToken(loginRequestDTO.getUsername(), claims);

        return new LoginResponseDTO(token, loginRequestDTO.getUsername(), null, "login_success");
    }



}
