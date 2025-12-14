package com.example.authDemo.Controller;

import com.example.authDemo.Entity.UserEntity;
import com.example.authDemo.Services.JwtService;
import com.example.authDemo.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value="/api/users")
public class UserController {

    private final JwtService jwtService;
    private final UserService userService;

    public UserController(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public String getUsers() {
        return "List of users";
    }

    @PostMapping("/login")
    public String loginUser() {
        return " Login Successful. Token: " + jwtService.getJwtToken();
    }

    @PostMapping("/getUsername")
    public String getUsernameFromToken(@RequestParam String token) {
        return jwtService.getUserNameFromToken(token);
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }
}
