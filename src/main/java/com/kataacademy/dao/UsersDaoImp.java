package com.kataacademy.dao;

import com.kataacademy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsersDaoImp implements UsersDao {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        entityManager.createQuery("delete from User where id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }



}
