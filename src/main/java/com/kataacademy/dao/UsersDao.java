package com.kataacademy.dao;

import com.kataacademy.model.User;

import java.util.List;

public interface UsersDao {

    List<User> getAllUsers();

    User getUserById(long id);

    void addUser(User user);

    void deleteUser(long id);

    void editUser(User user);


}
