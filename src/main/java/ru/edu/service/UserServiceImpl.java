package ru.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.dao.UserDao;
import ru.edu.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getListOfUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        User user = findUserById(id);
        userDao.deleteUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Override
    @Transactional
    public void editUser(User user, Long id) {
        User updatableUser = findUserById(id);
        updatableUser.setName(user.getName());
        updatableUser.setEmail(user.getEmail());
        updatableUser.setAge(user.getAge());
    }
}
