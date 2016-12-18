package ru.itis.inform.service.interfaces;

import ru.itis.inform.models.Vendor;

import java.util.List;

/**
 * Created by artur on 14.12.2016.
 */
public interface VendorService {

    Vendor getById(int vendorId);

    Vendor getByUserId(int userId);

    List<Vendor> getAll();

    void update(Vendor vendor);
}
