package com.mindera.users.service;

import com.mindera.users.model.User;
import com.mindera.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class UserService {

        public final UserRepository repository = new UserRepository();

    public List<User> getUsers() {
        return repository.getUsers();
    }
    public User addUser(final User user) {
        return repository.addUser(user);
    }

    public User getUserById(final Long userId) {
        return repository.getUserById(userId);
    }


}
