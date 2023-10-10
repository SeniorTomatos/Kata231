package com.kataacademy.controller;

import com.kataacademy.model.User;
import com.kataacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/add")
    public String getFormForCreateNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create";
    }

    @PostMapping("/saveNewUser")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUserById(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String getFormForEditUser(Model model, @PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/saveUpdatedUser")
    public String saveUpdatedUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }
}
