package ru.itis.inform.service.impl;

import ru.itis.inform.dao.impl.UserDaoImpl;
import ru.itis.inform.dao.interfaces.UserDao;
import ru.itis.inform.models.User;
import ru.itis.inform.service.interfaces.UserService;

import java.util.List;

/**
 * Created by artur on 14.12.2016.
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public User getById(int userId) {
        return userDao.getById(userId);
    }

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public boolean isCustomer(int userId) {
        return userDao.isCustomer(userId);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void insertCustomer(User user, String phone) {
        userDao.insertCustomer(user, phone);
    }

    @Override
    public void insertVendor(User user, String phone) {
        userDao.insertVendor(user, phone);
    }

    @Override
    public boolean verifyLoginExistence(String login) {
        return userDao.verifyLoginExistence(login);
    }

    @Override
    public boolean verifyCustomerPhoneExistence(String phone) {
        return userDao.verifyCustomerPhoneExistence(phone);
    }

    @Override
    public boolean verifyVendorPhoneExistence(String phone) {
        return userDao.verifyVendorPhoneExistence(phone);
    }
}
