package com.stanrunge.proj2.controllers.data;

import com.stanrunge.proj2.repositories.UserRepository;
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
    public void createUser(User user) {
        userRepository.save(user);
    }

    @GetMapping("/")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/")
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
