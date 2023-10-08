package com.kataacademy.service;

import com.kataacademy.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    User getUserById(long id);

    void deleteUser(long id);

    void editUser(User user);
}
