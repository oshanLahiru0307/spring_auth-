package com.example.authDemo.Repository;


import com.example.authDemo.Entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
   Optional<UserEntity> findByUsername(String username);
}

