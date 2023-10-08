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
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @GetMapping("/user")
    public String getUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/add")
    public String addUser(User user) {
        return "create";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }


    @GetMapping("/delete")
    public String deleteUserById(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }


}
