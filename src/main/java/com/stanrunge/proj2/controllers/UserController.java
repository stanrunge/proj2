package com.stanrunge.proj2.controllers;

import com.stanrunge.proj2.UserRepository;
import com.stanrunge.proj2.data.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser() {
        userRepository.save(new User());
    }

    @GetMapping("/")
    public User getUserByUsername(String username) {
        Iterable<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
