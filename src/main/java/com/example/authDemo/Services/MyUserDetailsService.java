package com.example.authDemo.Services;

import com.example.authDemo.Entity.UserEntity;
import com.example.authDemo.Repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userInfo = userRepository.findByUsername(username).orElse(null);
        if (userInfo == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        System.out.println(userInfo.getUsername());

        try{
            UserDetails user = User.builder()
                    .username(userInfo.getUsername())
                    .password(userInfo.getPassword())
                    .build();
            return user;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
