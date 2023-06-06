package com.trabalhobd.backend.controller;

import com.trabalhobd.backend.exceptions.UserNotFoundException;
import com.trabalhobd.backend.model.User;
import com.trabalhobd.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException(userId));
    }

    @PutMapping("/user/{userId}")
    User updateUser(@RequestBody User userPutRequest, @PathVariable Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setUsername(userPutRequest.getUsername());
                    user.setName(userPutRequest.getName());
                    user.setEmail(userPutRequest.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(()-> new UserNotFoundException(userId));

    }

    @DeleteMapping("/user/{userId}")
    String deleteUser(@PathVariable Long userId) {
        if(!userRepository.existsById(userId)){
            throw new UserNotFoundException(userId);
        }
        userRepository.deleteById(userId);
        return "User with id " + userId + " was deleted successfully";
    }
}
