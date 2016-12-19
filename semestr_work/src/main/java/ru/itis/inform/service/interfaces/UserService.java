package ru.itis.inform.service.interfaces;

import ru.itis.inform.models.User;

import java.util.List;

/**
 * Created by artur on 14.12.2016.
 */
public interface UserService {

    User getById(int userId);

    User getByUsername(String username);

    List<User> getAll();

    boolean isCustomer(int userId);

    void insertCustomer(User user, String phone);

    void insertVendor(User user, String phone);

    void deleteUser(int userId);

    void update(User user);

    boolean verifyLoginExistence(String login);

    boolean verifyCustomerPhoneExistence(String phone);

    boolean verifyVendorPhoneExistence(String phone);
}
