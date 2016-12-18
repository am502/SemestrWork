package ru.itis.inform.service.impl;

import ru.itis.inform.dao.impl.VendorDaoImpl;
import ru.itis.inform.dao.interfaces.VendorDao;
import ru.itis.inform.models.Vendor;
import ru.itis.inform.service.interfaces.VendorService;

import java.util.List;

/**
 * Created by artur on 14.12.2016.
 */
public class VendorServiceImpl implements VendorService {

    VendorDao vendorDao = new VendorDaoImpl();

    @Override
    public Vendor getById(int vendorId) {
        return vendorDao.getById(vendorId);
    }

    @Override
    public Vendor getByUserId(int userId) {
        return vendorDao.getByUserId(userId);
    }

    @Override
    public List<Vendor> getAll() {
        return vendorDao.getAll();
    }

    @Override
    public void update(Vendor vendor) {
        vendorDao.update(vendor);
    }
}
