package ru.itis.inform.dao.impl;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.inform.configs.DataConfig;
import ru.itis.inform.dao.interfaces.ArchiveDao;
import ru.itis.inform.dao.mappers.ArchiveMapper;
import ru.itis.inform.models.Archive;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by artur on 08.11.16.
 */
public class ArchiveDaoImpl implements ArchiveDao {

    DataConfig config = new DataConfig();
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = config.namedParameterJdbcTemplate();

    private static final String SQL_FIND_ALL = "SELECT * FROM archive;";

    private static final String SQL_FIND_BY_VENDOR_ID = "SELECT * FROM archive WHERE vendor_id = :vendorId;";

    private static final String SQL_FIND_BY_CUSTOMER_ID = "SELECT * FROM archive WHERE customer_id = :customerId;";

    private static final String SQL_INSERT = "INSERT INTO archive VALUES (:vendorId, :customerId, " +
            ":goodName, :sellDate, :price, :customerComment);";

    @Override
    public Archive getByVendorId(int vendorId) {
        Map<String, Object> params = new HashMap();
        params.put("vendorId", vendorId);
        return (Archive) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_VENDOR_ID, params, new ArchiveMapper());
    }

    @Override
    public Archive getByCustomerId(int customerId) {
        Map<String, Object> params = new HashMap();
        params.put("customerId", customerId);
        return (Archive) namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_CUSTOMER_ID, params, new ArchiveMapper());
    }

    @Override
    public List<Archive> getAll() {
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL, new ArchiveMapper());
    }

    @Override
    public void insert(Archive archive) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String date = sdfDate.format(now);
        Map<String, Object> params = new HashMap();
        params.put("vendorId", archive.getVendorId());
        params.put("customerId", archive.getCustomerId());
        params.put("goodName", archive.getGoodName());
        params.put("sellDate", date);
        params.put("price", archive.getPrice());
        params.put("customerComment", archive.getComment());
        namedParameterJdbcTemplate.update(SQL_INSERT, params);
    }
}
