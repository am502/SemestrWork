package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.User;
import ru.itis.inform.models.Vendor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artur on 06.12.2016.
 */
public class VendorMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User.Builder()
                .userId(rs.getInt("user_id"))
                .lastName(rs.getString("last_name"))
                .firstName(rs.getString("first_name"))
                .build();
        return new Vendor.Builder()
                .vendorId(rs.getInt("vendor_id"))
                .user(user)
                .phoneNumber(rs.getString("phone_number"))
                .build();
    }
}
