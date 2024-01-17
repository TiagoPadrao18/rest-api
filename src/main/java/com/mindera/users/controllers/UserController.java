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

    @GetMapping("/get")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping
    public User addUser(@RequestBody final User user){
        return service.addUser(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable final Long userId){
        return service.getUserById(userId);
    }


    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable final Long userId) {
        service.deleteUserById(userId);
    }

}
