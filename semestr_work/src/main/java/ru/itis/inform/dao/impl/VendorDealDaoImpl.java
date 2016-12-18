package ru.itis.inform.dao.impl;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.inform.configs.DataConfig;
import ru.itis.inform.dao.interfaces.VendorDealDao;
import ru.itis.inform.dao.mappers.VendorDealMapper;
import ru.itis.inform.models.VendorDeal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by artur on 13.12.2016.
 */
public class VendorDealDaoImpl implements VendorDealDao {

    DataConfig config = new DataConfig();
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = config.namedParameterJdbcTemplate();

    private static final String INNER_JOIN = "SELECT uv.*, vd.vendor_deal_id, vd.good_name, vd.conditions_sale, " +
            "vd.lot_size_wholesale, vd.price, vd.payment_method deal_pm, vd.phone_number deal_phone, vd.note " +
            "FROM vendor_deals vd INNER JOIN user_vendor uv ON " +
            "vd.vendor_id = uv.vendor_id";

    private static final String SQL_INSERT = "INSERT INTO vendor_deals (vendor_id, good_name, " +
            "lot_size_wholesale, price, payment_method, phone_number, conditions_sale, note) " +
            "VALUES (:vendorId, :goodName, " +
            ":lotSizeWholesale, :price, :paymentMethod, :phoneNumber, :conditionsSale, :note);";

    private static final String SQL_DELETE = "DELETE FROM vendor_deals WHERE vendor_deal_id = :id;";

    private static final String SQL_UPDATE = "UPDATE vendor_deals SET (vendor_id, good_name, " +
            "lot_size_wholesale, price, payment_method, phone_number, conditions_sale, note) " +
            "= (:vendorId, :goodName, " +
            ":lotSizeWholesale, :price, :paymentMethod, :phoneNumber, :conditionsSale, :note) " +
            "WHERE vendor_deal_id = :id;";

    private static final String SQL_FIND_BY_ID = INNER_JOIN + " WHERE vd.vendor_deal_id = :id ORDER BY (vd.vendor_deal_id);";

    private static final String SQL_FIND_BY_VENDOR_ID = INNER_JOIN + " WHERE vd.vendor_id = :vendorId  ORDER BY (vd.vendor_deal_id);";

    private static final String SQL_FIND_ALL = INNER_JOIN + " ORDER BY (vd.vendor_deal_id);";

    private static final String SQL_MAX = "SELECT MAX(vendor_deal_id) FROM vendor_deals;";

    private static final String SQL_MIN = "SELECT MIN(vendor_deal_id) FROM vendor_deals;";

    @Override
    public void insert(VendorDeal vendorDeal) {
        Map<String, Object> params = new HashMap();
        params.put("vendorId", vendorDeal.getVendor().getVendorId());
        params.put("goodName", vendorDeal.getGoodName());
        params.put("lotSizeWholesale", vendorDeal.getLotSizeWholesale());
        params.put("price", vendorDeal.getPrice());
        params.put("paymentMethod", vendorDeal.getPaymentMethod());
        params.put("phoneNumber", vendorDeal.getPhoneNumber());
        params.put("conditionsSale", vendorDeal.getConditionsSale());
        params.put("note", vendorDeal.getNote());
        namedParameterJdbcTemplate.update(SQL_INSERT, params);
    }

    @Override
    public void delete(int id) {
        Map<String, Object> params = new HashMap();
        params.put("id", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }

    @Override
    public void update(VendorDeal vendorDeal) {
        Map<String, Object> params = new HashMap();
        params.put("id", vendorDeal.getVendorDealId());
        params.put("vendorId", vendorDeal.getVendor().getVendorId());
        params.put("goodName", vendorDeal.getGoodName());
        params.put("lotSizeWholesale", vendorDeal.getLotSizeWholesale());
        params.put("price", vendorDeal.getPrice());
        params.put("paymentMethod", vendorDeal.getPaymentMethod());
        params.put("phoneNumber", vendorDeal.getPhoneNumber());
        params.put("conditionsSale", vendorDeal.getConditionsSale());
        params.put("note", vendorDeal.getNote());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    @Override
    public List<VendorDeal> getAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new VendorDealMapper());
    }

    @Override
    public VendorDeal getById(int id) {
        Map<String, Object> params = new HashMap();
        params.put("id", id);
        return (VendorDeal) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, params, new VendorDealMapper());
    }

    @Override
    public List<VendorDeal> getByVendorId(int vendorId) {
        Map<String, Object> params = new HashMap();
        params.put("vendorId", vendorId);
        return namedParameterJdbcTemplate.query(SQL_FIND_BY_VENDOR_ID, params, new VendorDealMapper());
    }

    @Override
    public int getMax() {
        return namedParameterJdbcTemplate.queryForObject(SQL_MAX, new HashMap<String, Object>(), int.class);
    }

    @Override
    public int getMin() {
        return namedParameterJdbcTemplate.queryForObject(SQL_MIN, new HashMap<String, Object>(), int.class);
    }
}
