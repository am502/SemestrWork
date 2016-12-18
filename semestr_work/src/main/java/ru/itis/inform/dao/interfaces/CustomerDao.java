package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Customer;

import java.util.List;

/**
 * Created by artur on 06.12.2016.
 */
public interface CustomerDao {

    Customer getById(int customerId);

    Customer getByUserId(int userId);

    List<Customer> getAll();

    void update(Customer customer);
}
