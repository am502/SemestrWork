package ru.itis.inform.dao.impl;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.inform.configs.DataConfig;
import ru.itis.inform.dao.interfaces.VendorDao;
import ru.itis.inform.dao.mappers.VendorMapper;
import ru.itis.inform.models.Vendor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by artur on 06.12.2016.
 */
public class VendorDaoImpl implements VendorDao {

    DataConfig config = new DataConfig();
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = config.namedParameterJdbcTemplate();

    private static final String SQL_FIND_BY_ID = "SELECT * FROM user_vendor WHERE vendor_id = :vendorId AND status = 'ACTIVE';";

    private static final String SQL_FIND_BY_USER_ID = "SELECT * FROM user_vendor WHERE user_id = :userId AND status = 'ACTIVE';";

    private static final String SQL_FIND_ALL = "SELECT * FROM user_vendor WHERE status = 'ACTIVE';";

    private static final String SQL_UPDATE = "UPDATE vendors SET phone_number = :phone WHERE vendor_id = :id;";

    @Override
    public Vendor getById(int vendorId) {
        Map<String, Object> params = new HashMap();
        params.put("vendorId", vendorId);
        return (Vendor) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, params, new VendorMapper());
    }

    @Override
    public Vendor getByUserId(int userId) {
        Map<String, Object> params = new HashMap();
        params.put("userId", userId);
        return (Vendor) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_USER_ID, params, new VendorMapper());
    }

    @Override
    public List<Vendor> getAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new VendorMapper());
    }

    @Override
    public void update(Vendor vendor) {
        Map<String, Object> params = new HashMap();
        params.put("id", vendor.getVendorId());
        params.put("phone", vendor.getPhoneNumber());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }
}
