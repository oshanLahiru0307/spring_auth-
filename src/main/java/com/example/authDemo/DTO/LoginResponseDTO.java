package com.example.authDemo.DTO;

public class LoginResponseDTO {

    private String token;
    private String username;
    private String errorMessage;
    private String message;

    public LoginResponseDTO(String token, String username, String errorMessage, String message) {
        this.token = token;
        this.username = username;
        this.errorMessage = errorMessage;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
