package ru.itis.inform.service.interfaces;

import ru.itis.inform.models.Customer;

import java.util.List;

/**
 * Created by artur on 14.12.2016.
 */
public interface CustomerService {

    Customer getById(int customerId);

    Customer getByUserId(int userId);

    List<Customer> getAll();

    void update(Customer customer);
}
