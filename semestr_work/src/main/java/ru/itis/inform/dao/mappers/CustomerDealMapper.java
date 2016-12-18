package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.Customer;
import ru.itis.inform.models.CustomerDeal;
import ru.itis.inform.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artur on 08.11.16.
 */
public class CustomerDealMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User.Builder()
                .userId(resultSet.getInt("user_id"))
                .lastName(resultSet.getString("last_name"))
                .firstName(resultSet.getString("first_name"))
                .build();
        Customer customer = new Customer.Builder()
                .customerId(resultSet.getInt("customer_id"))
                .user(user)
                .phoneNumber(resultSet.getString("phone_number"))
                .build();
        return new CustomerDeal.Builder()
                .customerDealId(resultSet.getInt("customer_deal_id"))
                .customer(customer)
                .goodName(resultSet.getString("good_name"))
                .lotSize(resultSet.getInt("lot_size"))
                .price(resultSet.getInt("price"))
                .paymentMethod(resultSet.getString("deal_pm"))
                .phoneNumber(resultSet.getString("deal_phone"))
                .note(resultSet.getString("note"))
                .build();
    }
}
