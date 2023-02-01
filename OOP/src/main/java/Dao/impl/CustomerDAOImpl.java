package Dao.impl;

import Dao.CustomerDAO;
import Model.Customer;
import Util.DB_Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public int save(Customer customer) {
        try(Connection connection = DB_Util.getInstance().getConnection()){
            String sql = "INSERT INTO CUSTOMERS VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.setInt(4, customer.getAddressId());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }
    }

    @Override
    public List<Customer> showAll() {
        try (Connection connection = DB_Util.getInstance().getConnection()) {
            String sql = "SELECT * FROM CUSTOMERS";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("CUSTOMER_ID");
                String fullName = resultSet.getString("FULL_NAME");
                String email = resultSet.getString("EMAIL");
                String phoneNumber = resultSet.getString("PHONE_NUMBER");
                int addressID = resultSet.getInt("ADDRESS_ID");
                customers.add(new Customer(id, fullName, email,phoneNumber,addressID));
            }

            return customers;
        } catch (Exception e) {
            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
