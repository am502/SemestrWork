package ru.itis.inform.service.impl;

import ru.itis.inform.dao.impl.CustomerDealDaoImpl;
import ru.itis.inform.dao.interfaces.CustomerDealDao;
import ru.itis.inform.models.CustomerDeal;
import ru.itis.inform.service.interfaces.CustomerDealService;

import java.util.List;

/**
 * Created by artur on 14.12.2016.
 */
public class CustomerDealServiceImpl implements CustomerDealService {

    CustomerDealDao customerDealDao = new CustomerDealDaoImpl();

    @Override
    public void insert(CustomerDeal customerDeal) {
        customerDealDao.insert(customerDeal);
    }

    @Override
    public void delete(int id) {
        customerDealDao.delete(id);
    }

    @Override
    public void update(CustomerDeal customerDeal) {
        customerDealDao.update(customerDeal);
    }

    @Override
    public List<CustomerDeal> getAll() {
        return customerDealDao.getAll();
    }

    @Override
    public CustomerDeal getById(int id) {
        return customerDealDao.getById(id);
    }

    @Override
    public List<CustomerDeal> getByCustomerId(int customerId) {
        return customerDealDao.getByCustomerId(customerId);
    }

    @Override
    public int getMax() {
        return customerDealDao.getMax();
    }

    @Override
    public int getMin() {
        return customerDealDao.getMin();
    }
}
