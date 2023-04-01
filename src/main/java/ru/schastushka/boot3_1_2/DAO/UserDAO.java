package ru.schastushka.boot3_1_2.DAO;

import ru.schastushka.boot3_1_2.model.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    List<User> getAllUser();

    User getById(Long id);
}