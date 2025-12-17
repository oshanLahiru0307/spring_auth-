package com.example.authDemo.Controller;

import com.example.authDemo.DTO.LoginRequestDTO;
import com.example.authDemo.DTO.LoginResponseDTO;
import com.example.authDemo.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO loginResponseDTO = userService.login(loginRequestDTO);
        if(loginResponseDTO.getErrorMessage() == null) {
            return ResponseEntity.ok(loginResponseDTO);
        }else{
            return ResponseEntity.badRequest().body(loginResponseDTO);
        }

    }
}
