package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.User;

import java.util.List;

/**
 * Created by artur on 11.11.16.
 */
public interface UserDao {

    User getById(int userId);

    User getByUsername(String username);

    List<User> getAll();

    void insertCustomer(User user, String phone);

    void insertVendor(User user, String phone);

    boolean isCustomer(int userId);

    void deleteUser(int userId);

    void update(User user);

    boolean verifyLoginExistence(String login);
}
