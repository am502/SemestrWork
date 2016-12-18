package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.VendorDeal;

import java.util.List;

/**
 * Created by artur on 12.12.2016.
 */
public interface VendorDealDao {

    void insert(VendorDeal vendorDeal);

    void delete(int id);

    void update(VendorDeal vendorDeal);

    List<VendorDeal> getAll();

    VendorDeal getById(int id);

    List<VendorDeal> getByVendorId(int vendorId);

    int getMax();

    int getMin();
}
