package ru.itis.inform.service.impl;

import ru.itis.inform.dao.impl.VendorDealDaoImpl;
import ru.itis.inform.dao.interfaces.VendorDealDao;
import ru.itis.inform.models.VendorDeal;
import ru.itis.inform.service.interfaces.VendorDealService;

import java.util.List;

/**
 * Created by artur on 14.12.2016.
 */
public class VendorDealServiceImpl implements VendorDealService {

    VendorDealDao vendorDealDao = new VendorDealDaoImpl();

    @Override
    public void insert(VendorDeal vendorDeal) {
        vendorDealDao.insert(vendorDeal);
    }

    @Override
    public void delete(int id) {
        vendorDealDao.delete(id);
    }

    @Override
    public void update(VendorDeal vendorDeal) {
        vendorDealDao.update(vendorDeal);
    }

    @Override
    public List<VendorDeal> getAll() {
        return vendorDealDao.getAll();
    }

    @Override
    public VendorDeal getById(int id) {
        return vendorDealDao.getById(id);
    }

    @Override
    public List<VendorDeal> getByVendorId(int vendorId) {
        return vendorDealDao.getByVendorId(vendorId);
    }

    @Override
    public int getMax() {
        return vendorDealDao.getMax();
    }

    @Override
    public int getMin() {
        return vendorDealDao.getMin();
    }
}
