package com.mindera.users.repository;

import com.mindera.users.model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UserRepository {

    private Long count = 0L;
    private final List<User> users = new LinkedList<>();

   public List<User> getUsers(){
       return users;
   }


    public User addUser (final User user) {
       String file = "users.txt";

       try{
           BufferedWriter writer = new BufferedWriter(new FileWriter(file));
           final var newUser = User.builder()
                   .id(count)
                   .name(user.getName())
                   .password(user.getPassword())
                   .build();
           users.add(newUser);
           count+=1;
            writer.write(user.getName());
            writer.close();
           return newUser;

       } catch (IOException e){
           System.out.println(e.getMessage());
       }
       return null;
    }

    public User getUserById(final Long userId) {
        return users.get(Math.toIntExact(userId));
    }

}
