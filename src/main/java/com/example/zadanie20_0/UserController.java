package com.example.zadanie20_0;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    @ResponseBody
    String printUsers() {
        List<User> users = userRepository.getUsers();
        StringBuilder usersInfo = new StringBuilder();
        for (User user : users) {
            usersInfo.append(user).append("<br>");
        }
        return usersInfo.toString();
    }

    @GetMapping("/add")
    String addUser(@RequestParam(value = "imie") String firstName,
                   @RequestParam(value = "nazwisko") String lastName,
                   @RequestParam(value = "wiek") int age) {
        List<User> users = userRepository.getUsers();
        if (firstName != null && !firstName.isEmpty()) {
            users.add(new User(firstName, lastName, age));
            return "redirect:/success.html";
        } else {
            return "redirect:/err.html";
        }
    }

    @RequestMapping("/add")
    String FormAddUser(@RequestParam String firstName,
                       @RequestParam String lastName,
                       @RequestParam int age) {
        List<User> users = userRepository.getUsers();
        if (firstName != null && !firstName.isEmpty()) {
            users.add(new User(firstName, lastName, age));
            return "redirect:/success.html";
        } else {
            return "redirect:/err.html";
        }
    }
}
