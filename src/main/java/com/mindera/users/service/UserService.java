package com.mindera.users.service;

import com.mindera.users.interfaces.UserRepository;
import com.mindera.users.model.User;
import com.mindera.users.repository.UserRepositoryFileInpt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserRepository {

        public final UserRepositoryFileInpt repository = new UserRepositoryFileInpt();

    public List<User> getUsers() {
        return repository.getUsers();
    }

    @Override
    public User getUserById(final Long userId) {
        return repository.getUserById(userId);
    }

    @Override
    public User addUser(final User user) {
        return repository.addUser(user);
    }



    @Override
        public void deleteUserById(final Long userId) {
        repository.deleteUserById(userId);
        }


}
