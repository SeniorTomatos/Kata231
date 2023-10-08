package com.kataacademy.service;

import com.kataacademy.dao.UsersDao;
import com.kataacademy.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersServiceImp implements UserService {

    private final UsersDao usersDao;


    @Override
    public void addUser(User user) {
        usersDao.addUser(user);
    }


    @Override
    public List<User> getAllUsers() {
        return usersDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return usersDao.getUserById(id);
    }

    @Override
    public void deleteUser(long id) {
        usersDao.deleteUser(id);
    }

    @Override
    public void editUser(User user) {
        usersDao.editUser(user);
    }
}
