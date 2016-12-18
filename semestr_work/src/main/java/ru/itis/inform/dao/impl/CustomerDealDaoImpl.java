package ru.itis.inform.dao.impl;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.inform.configs.DataConfig;
import ru.itis.inform.dao.interfaces.CustomerDealDao;
import ru.itis.inform.dao.mappers.CustomerDealMapper;
import ru.itis.inform.models.CustomerDeal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by artur on 13.12.2016.
 */
public class CustomerDealDaoImpl implements CustomerDealDao {

    DataConfig config = new DataConfig();
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = config.namedParameterJdbcTemplate();

    private static final String INNER_JOIN = "SELECT uc.*, cd.customer_deal_id, cd.good_name, cd.lot_size, " +
            "cd.price, cd.payment_method deal_pm, cd.phone_number deal_phone, cd.note " +
            "FROM customer_deals cd INNER JOIN user_customer uc ON " +
            "cd.customer_id = uc.customer_id";

    private static final String SQL_INSERT = "INSERT INTO customer_deals (customer_id, good_name, " +
            "lot_size, price, payment_method, phone_number, note) " +
            "VALUES (:customerId, :goodName, " +
            ":lotSize, :price, :paymentMethod, :phoneNumber, :note);";

    private static final String SQL_DELETE = "DELETE FROM customer_deals WHERE customer_deal_id = :id;";

    private static final String SQL_UPDATE = "UPDATE customer_deals SET (customer_id, good_name, " +
            "lot_size, price, payment_method, phone_number, note) " +
            "= (:customerId, :goodName, " +
            ":lotSize, :price, :paymentMethod, :phoneNumber, :note) WHERE customer_deal_id = :id;";

    private static final String SQL_FIND_BY_ID = INNER_JOIN + " WHERE cd.customer_deal_id = :id ORDER BY (cd.customer_deal_id);";

    private static final String SQL_FIND_BY_CUSTOMER_ID = INNER_JOIN + " WHERE cd.customer_id = :customerId ORDER BY (cd.customer_deal_id);";

    private static final String SQL_FIND_ALL = INNER_JOIN + " ORDER BY (cd.customer_deal_id);";

    private static final String SQL_MAX = "SELECT MAX(customer_deal_id) FROM customer_deals;";

    private static final String SQL_MIN = "SELECT MIN(customer_deal_id) FROM customer_deals;";

    @Override
    public void insert(CustomerDeal customerDeal) {
        Map<String, Object> params = new HashMap();
        params.put("customerId", customerDeal.getCustomer().getCustomerId());
        params.put("goodName", customerDeal.getGoodName());
        params.put("lotSize", customerDeal.getLotSize());
        params.put("price", customerDeal.getPrice());
        params.put("paymentMethod", customerDeal.getPaymentMethod());
        params.put("phoneNumber", customerDeal.getPhoneNumber());
        params.put("note", customerDeal.getNote());
        namedParameterJdbcTemplate.update(SQL_INSERT, params);
    }

    @Override
    public void delete(int id) {
        Map<String, Object> params = new HashMap();
        params.put("id", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }

    @Override
    public void update(CustomerDeal customerDeal) {
        Map<String, Object> params = new HashMap();
        params.put("id", customerDeal.getCustomerDealId());
        params.put("customerId", customerDeal.getCustomer().getCustomerId());
        params.put("goodName", customerDeal.getGoodName());
        params.put("lotSize", customerDeal.getLotSize());
        params.put("price", customerDeal.getPrice());
        params.put("paymentMethod", customerDeal.getPaymentMethod());
        params.put("phoneNumber", customerDeal.getPhoneNumber());
        params.put("note", customerDeal.getNote());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    @Override
    public List<CustomerDeal> getAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new CustomerDealMapper());
    }

    @Override
    public CustomerDeal getById(int id) {
        Map<String, Object> params = new HashMap();
        params.put("id", id);
        return (CustomerDeal) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, params, new CustomerDealMapper());
    }

    @Override
    public List<CustomerDeal> getByCustomerId(int customerId) {
        Map<String, Object> params = new HashMap();
        params.put("customerId", customerId);
        return namedParameterJdbcTemplate.query(SQL_FIND_BY_CUSTOMER_ID, params, new CustomerDealMapper());
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
