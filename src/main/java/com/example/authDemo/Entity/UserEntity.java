package com.example.authDemo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private String username;
    private String password;

    public UserEntity() {
    }

    public UserEntity(String id, String name, String email, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String userInfo() {
        return "{" + '\n' +
                "id= " + id + ',' + '\n' +
                "name= " + name + ',' + '\n' +
                "email= " + email  + ',' +  '\n' +
                "username= " + username + ',' +  '\n' +
                "password= " + password + '\n' +
                '}';
    }

}
