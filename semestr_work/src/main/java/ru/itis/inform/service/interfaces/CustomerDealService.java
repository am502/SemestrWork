package ru.itis.inform.service.interfaces;

import ru.itis.inform.models.CustomerDeal;

import java.util.List;

/**
 * Created by artur on 14.12.2016.
 */
public interface CustomerDealService {

    void insert(CustomerDeal customerDeal);

    void delete(int id);

    void update(CustomerDeal customerDeal);

    List<CustomerDeal> getAll();

    CustomerDeal getById(int id);

    List<CustomerDeal> getByCustomerId(int customerId);

    int getMax();

    int getMin();
}
