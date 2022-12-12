package ru.edu.dao;

import org.springframework.stereotype.Repository;
import ru.edu.model.User;

import javax.persistence.*;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
