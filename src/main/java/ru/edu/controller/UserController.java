package ru.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.edu.model.User;
import ru.edu.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String allUsersPage(Model model) {
        List<User> users = userService.getListOfUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/new")
    public String createUserPage(@ModelAttribute("user") User user) {
        return "user_new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String removeUser(@PathVariable ("id") Long id){
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String EditUserPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "user_edit";
    }

    @PostMapping("edit/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.editUser(user, id);
        return "redirect:/";
    }
}
