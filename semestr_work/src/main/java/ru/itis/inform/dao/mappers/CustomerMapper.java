package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.Customer;
import ru.itis.inform.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artur on 08.11.16.
 */
public class CustomerMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User.Builder()
                .userId(resultSet.getInt("user_id"))
                .lastName(resultSet.getString("last_name"))
                .firstName(resultSet.getString("first_name"))
                .build();
        return new Customer.Builder()
                .customerId(resultSet.getInt("customer_id"))
                .user(user)
                .phoneNumber(resultSet.getString("phone_number"))
                .build();
    }
}
