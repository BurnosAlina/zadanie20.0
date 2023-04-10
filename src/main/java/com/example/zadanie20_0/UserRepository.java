package com.example.zadanie20_0;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository(List<User> users) {
        this.users = users;
        users.add(new User("Jan", "Kowalski", 21));
        users.add(new User("Anna", "Burnopka", 33));
        users.add(new User("John", "Snow", 45));
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
