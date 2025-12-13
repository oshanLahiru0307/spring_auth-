package com.example.authDemo.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value="/api/users")
public class UserController {

    @GetMapping("/getAll")
    public String getUsers() {
        return "List of users";
    }

    @PostMapping("/login")
    public String loginUser() {
        return "User logged in";
    }
}
