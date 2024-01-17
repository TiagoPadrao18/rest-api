package com.mindera.users.controllers;

import com.mindera.users.model.User;
import com.mindera.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {

    private final UserService service;

    @GetMapping
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping
    public User addUser(@RequestBody final User user){
        return service.addUser(user);
    }

    @GetMapping("/{userId}/{name}")
    public User getUserById(@PathVariable final String name, @PathVariable final Long userId){
        return service.getUserById(userId);
    }
}
