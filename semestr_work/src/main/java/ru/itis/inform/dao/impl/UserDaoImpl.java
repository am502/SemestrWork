package ru.itis.inform.dao.impl;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.inform.configs.DataConfig;
import ru.itis.inform.dao.interfaces.UserDao;
import ru.itis.inform.dao.mappers.UserMapper;
import ru.itis.inform.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by artur on 11.11.16.
 */
public class UserDaoImpl implements UserDao {

    DataConfig config = new DataConfig();
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = config.namedParameterJdbcTemplate();

    private static final String SQL_VERIFY = "SELECT CASE WHEN EXISTS (SELECT user_id FROM users WHERE login = :login) THEN TRUE ELSE FALSE END;";

    private static final String SQL_VERIFY_CUSTOMER_PHONE = "SELECT CASE WHEN EXISTS (SELECT user_id FROM user_customer WHERE phone_number = :phone AND status = 'ACTIVE') THEN TRUE ELSE FALSE END;";

    private static final String SQL_VERIFY_VENDOR_PHONE = "SELECT CASE WHEN EXISTS (SELECT user_id FROM user_vendor WHERE phone_number = :phone AND status = 'ACTIVE') THEN TRUE ELSE FALSE END;";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM users WHERE user_id = :userId;";

    private static final String SQL_FIND_ALL = "SELECT * FROM users;";

    private static final String SQL_FIND_BY_USERNAME = "SELECT * FROM users WHERE login = :username;";

    private static final String SQL_VERIFY_CUSTOMER = "SELECT CASE WHEN EXISTS (SELECT user_id FROM user_customer WHERE user_id = :userId) THEN TRUE ELSE FALSE END;";

    private static final String SQL_DELETE_BY_ID = "DELETE FROM users WHERE user_id = :userId;";

    private static final String SQL_UPDATE = "UPDATE users SET (last_name, first_name) = (:lastName, :firstName) " +
            "WHERE user_id = :id;";

    private static final String SQL_INSERT_CUSTOMER = "SELECT add_customer(:login, :password, :firstName, :lastName, :phone);";

    private static final String SQL_INSERT_VENDOR = "SELECT add_vendor(:login, :password, :firstName, :lastName, :phone);";

    @Override
    public User getById(int userId) {
        Map<String, Object> params = new HashMap();
        params.put("userId", userId);
        return (User) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, params, new UserMapper());
    }

    @Override
    public User getByUsername(String username) {
        Map<String, Object> params = new HashMap();
        params.put("username", username);
        return (User) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_USERNAME, params, new UserMapper());
    }

    @Override
    public List<User> getAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new UserMapper());
    }

    @Override
    public boolean isCustomer(int userId) {
        Map<String, Object> params = new HashMap();
        params.put("userId", userId);
        return namedParameterJdbcTemplate.queryForObject(SQL_VERIFY_CUSTOMER, params, boolean.class);
    }

    @Override
    public void deleteUser(int userId) {
        Map<String, Object> params = new HashMap();
        params.put("userId", userId);
        namedParameterJdbcTemplate.update(SQL_DELETE_BY_ID, params);
    }

    @Override
    public void update(User user) {
        Map<String, Object> params = new HashMap();
        params.put("id", user.getUserId());
        params.put("lastName", user.getLastName());
        params.put("firstName", user.getFirstName());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    @Override
    public void insertCustomer(User user, String phone) {
        Map<String, Object> params = new HashMap();
        params.put("login", user.getLogin());
        params.put("password", user.getPassword());
        params.put("firstName", user.getFirstName());
        params.put("lastName", user.getLastName());
        params.put("phone", phone);
        namedParameterJdbcTemplate.queryForObject(SQL_INSERT_CUSTOMER, params, String.class);
    }

    @Override
    public void insertVendor(User user, String phone) {
        Map<String, Object> params = new HashMap();
        params.put("login", user.getLogin());
        params.put("password", user.getPassword());
        params.put("firstName", user.getFirstName());
        params.put("lastName", user.getLastName());
        params.put("phone", phone);
        namedParameterJdbcTemplate.queryForObject(SQL_INSERT_VENDOR, params, String.class);
    }

    @Override
    public boolean verifyLoginExistence(String login) {
        Map<String, Object> params = new HashMap();
        params.put("login", login);
        return namedParameterJdbcTemplate.queryForObject(SQL_VERIFY, params, boolean.class);
    }

    @Override
    public boolean verifyCustomerPhoneExistence(String phone) {
        Map<String, Object> params = new HashMap();
        params.put("phone", phone);
        return namedParameterJdbcTemplate.queryForObject(SQL_VERIFY_CUSTOMER_PHONE, params, boolean.class);
    }

    @Override
    public boolean verifyVendorPhoneExistence(String phone) {
        Map<String, Object> params = new HashMap();
        params.put("phone", phone);
        return namedParameterJdbcTemplate.queryForObject(SQL_VERIFY_VENDOR_PHONE, params, boolean.class);
    }
}
