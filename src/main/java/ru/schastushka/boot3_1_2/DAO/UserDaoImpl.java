package ru.schastushka.boot3_1_2.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.schastushka.boot3_1_2.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    @Autowired
     private EntityManager entityManager;


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery(
                "SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }
}
