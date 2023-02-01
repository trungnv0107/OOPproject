package Dao.impl;

import Dao.AddressDAO;
import Model.Address;
import Util.DB_Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {
    @Override
    public List<Address> showAll() {
        try (Connection connection = DB_Util.getInstance().getConnection()) {
            String sql = "SELECT * FROM ADDRESS";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<Address> addresses = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("ADDRESS_ID");
                String city = resultSet.getString("CITY");
                String district = resultSet.getString("DISTRICT");
                String subDistrict = resultSet.getString("SUB_DISTRICT");
                String postalCode = resultSet.getString("POSTAL_CODE");
                double deliveryFee = resultSet.getDouble("DELIVERY_FEE");


                addresses.add(new Address(id, city, district, subDistrict, postalCode,deliveryFee));
            }

            return addresses;
        } catch (Exception e) {
            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
