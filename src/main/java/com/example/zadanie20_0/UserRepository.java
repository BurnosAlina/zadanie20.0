package com.example.zadanie20_0;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User("Jan", "Kowalski", 21));
        users.add(new User("Anna", "Burnopka", 33));
        users.add(new User("John", "Snow", 45));
    }

    void addUser(User user) {
        users.add(user);
    }

    String printUsersInfo() {
        StringBuilder usersInfo = new StringBuilder();
        for (User user : users) {
            usersInfo.append(user).append("<br>");
        }
        return usersInfo.toString();
    }
}
