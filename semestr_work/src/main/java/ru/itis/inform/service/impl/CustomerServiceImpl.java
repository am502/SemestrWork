package ru.itis.inform.service.impl;

import ru.itis.inform.dao.impl.CustomerDaoImpl;
import ru.itis.inform.dao.interfaces.CustomerDao;
import ru.itis.inform.models.Customer;
import ru.itis.inform.service.interfaces.CustomerService;

import java.util.List;

/**
 * Created by artur on 14.12.2016.
 */
public class CustomerServiceImpl implements CustomerService {

    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public Customer getById(int customerId) {
        return customerDao.getById(customerId);
    }

    @Override
    public Customer getByUserId(int userId) {
        return customerDao.getByUserId(userId);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }
}
