package ru.itis.inform.dao.impl;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.inform.configs.DataConfig;
import ru.itis.inform.dao.interfaces.CustomerDao;
import ru.itis.inform.dao.mappers.CustomerMapper;
import ru.itis.inform.models.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by artur on 06.12.2016.
 */
public class CustomerDaoImpl implements CustomerDao {

    DataConfig config = new DataConfig();
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = config.namedParameterJdbcTemplate();

    private static final String SQL_FIND_BY_ID = "SELECT * FROM user_customer WHERE customer_id = :customerId AND status = 'ACTIVE';";

    private static final String SQL_FIND_BY_USER_ID = "SELECT * FROM user_customer WHERE user_id = :userId AND status = 'ACTIVE';";

    private static final String SQL_FIND_ALL = "SELECT * FROM user_customer WHERE status = 'ACTIVE';";

    private static final String SQL_UPDATE = "UPDATE customers SET phone_number = :phone WHERE customer_id = :id;";

    @Override
    public Customer getById(int customerId) {
        Map<String, Object> params = new HashMap();
        params.put("customerId", customerId);
        return (Customer) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, params, new CustomerMapper());
    }

    @Override
    public Customer getByUserId(int userId) {
        Map<String, Object> params = new HashMap();
        params.put("userId", userId);
        return (Customer) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_USER_ID, params, new CustomerMapper());
    }

    @Override
    public List<Customer> getAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new CustomerMapper());
    }

    @Override
    public void update(Customer customer) {
        Map<String, Object> params = new HashMap();
        params.put("id", customer.getCustomerId());
        params.put("phone", customer.getPhoneNumber());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }
}
