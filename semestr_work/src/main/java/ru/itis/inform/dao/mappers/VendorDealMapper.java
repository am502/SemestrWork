package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.User;
import ru.itis.inform.models.Vendor;
import ru.itis.inform.models.VendorDeal;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artur on 08.11.16.
 */
public class VendorDealMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User.Builder()
                .userId(resultSet.getInt("user_id"))
                .lastName(resultSet.getString("last_name"))
                .firstName(resultSet.getString("first_name"))
                .build();
        Vendor vendor = new Vendor.Builder()
                .vendorId(resultSet.getInt("vendor_id"))
                .user(user)
                .phoneNumber(resultSet.getString("phone_number"))
                .build();
        return new VendorDeal.Builder()
                .vendorDealId(resultSet.getInt("vendor_deal_id"))
                .vendor(vendor)
                .goodName(resultSet.getString("good_name"))
                .lotSizeWholesale(resultSet.getInt("lot_size_wholesale"))
                .price(resultSet.getInt("price"))
                .paymentMethod(resultSet.getString("deal_pm"))
                .phoneNumber(resultSet.getString("deal_phone"))
                .conditionsSale(resultSet.getString("conditions_sale"))
                .note(resultSet.getString("note"))
                .build();
    }
}
