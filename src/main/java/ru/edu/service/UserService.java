package ru.edu.service;

import ru.edu.model.User;

import java.util.List;

public interface UserService {

    List<User> getListOfUsers();
    void addUser(User user);
    void deleteUserById(Long id);
    User findUserById(Long id);

    void editUser(User user, Long id);
}
