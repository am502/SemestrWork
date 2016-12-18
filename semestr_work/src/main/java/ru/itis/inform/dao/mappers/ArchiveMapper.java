package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.Archive;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artur on 08.11.16.
 */
public class ArchiveMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Archive.Builder()
                .vendorId(resultSet.getInt("vendor_id"))
                .customerId(resultSet.getInt("customer_id"))
                .goodName(resultSet.getString("good_name"))
                .sellDate(resultSet.getString("sell_date"))
                .price(resultSet.getInt("price"))
                .comment(resultSet.getString("customer_comment"))
                .build();
    }
}
