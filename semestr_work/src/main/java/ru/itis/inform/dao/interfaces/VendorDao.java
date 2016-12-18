package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Vendor;

import java.util.List;

/**
 * Created by artur on 06.12.2016.
 */
public interface VendorDao {

    Vendor getById(int vendorId);

    Vendor getByUserId(int userId);

    List<Vendor> getAll();

    void update(Vendor vendor);
}
