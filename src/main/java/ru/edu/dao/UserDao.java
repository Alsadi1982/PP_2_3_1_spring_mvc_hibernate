package ru.edu.dao;

import ru.edu.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(User user);
    User findUserById(Long id);
}
