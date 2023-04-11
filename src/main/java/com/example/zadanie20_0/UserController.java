package com.example.zadanie20_0;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    @ResponseBody
    String printUsers() {
        return userRepository.printUsersInfo();
    }

    @RequestMapping("/add")
    String addUser(@RequestParam String firstName,
                   @RequestParam String lastName,
                   @RequestParam int age) {
        if (firstName != null && !firstName.isEmpty()) {
            userRepository.addUser(new User(firstName, lastName, age));
            return "redirect:/success.html";
        } else {
            return "redirect:/err.html";
        }
    }
}
