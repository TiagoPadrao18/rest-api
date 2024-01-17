package com.mindera.users.repository;

import com.mindera.users.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserRepositoryFileInpt {
    File file = new File("/Users/mindera/Documents/MSchool/BackEndDevelopment/users/src/main/resources/usersDb.txt");
    private Long count = 0L;
    private List<User> users = new LinkedList<>();

    public List<User> getUsers() {
        List<User> usersList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] part = line.split(",");
                if (part.length == 3) {
                    Long id = Long.parseLong(part[0]);
                    String name = part[1];
                    String password = part[2];
                    User user = User.builder()
                            .id(id)
                            .name(name)
                            .password(password)
                            .build();


                    usersList.add(user);

                } else {
                    System.out.println("invalid");
                }
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return usersList;

    }


    public User addUser(final User user) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            final var newUser = User.builder()
                    .id(count)
                    .name(user.getName())
                    .password(user.getPassword())
                    .build();

            count += 1;
            writer.write(String.valueOf(newUser));
            writer.newLine();
            writer.close();
            return newUser;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User getUserById(final Long userId) {
        return users.get(Math.toIntExact(userId));
    }

    public void deleteUserById(final Long userId) {


    }


}
