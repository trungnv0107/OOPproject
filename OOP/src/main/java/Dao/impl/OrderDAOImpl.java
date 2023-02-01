package Dao.impl;

import Dao.OrderDAO;
import Model.Order;
import Util.DB_Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public int save(Order order) {
        try (Connection connection = DB_Util.getInstance().getConnection()){
            java.sql.Date sqlDate ;
            String sql = "INSERT INTO ORDERS VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getName());
            preparedStatement.setString(2, phoneNumber());
            preparedStatement.setString(3, order.getDetailAddress());
            preparedStatement.setDouble(4, 0);
            preparedStatement.setDate(5, sqlDate = new java.sql.Date(System.currentTimeMillis()));
            preparedStatement.setInt(6, customerID());
            preparedStatement.setInt(7, addressID());
            preparedStatement.setInt(8, 1);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }
    }

    @Override
    public int customerID() {
        try(Connection connection = DB_Util.getInstance().getConnection()){
            int ketqua = 0;
            String cusID = "SELECT TOP 1 CUSTOMER_ID FROM CUSTOMERS ORDER BY CUSTOMER_ID DESC";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(cusID);
            while(rs.next()){
                ketqua = rs.getInt(1);
            }
            return ketqua;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String phoneNumber() {
        try(Connection connection = DB_Util.getInstance().getConnection()){
            String ketqua = null;
            String cusID = "SELECT TOP 1 PHONE_NUMBER FROM CUSTOMERS ORDER BY PHONE_NUMBER DESC";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(cusID);
            while(rs.next()){
                ketqua = rs.getString(1);
            }
            return ketqua;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addressID() {
        try(Connection connection = DB_Util.getInstance().getConnection()){
            int ketqua = 0;
            String cusID = "SELECT TOP 1 ADDRESS_ID FROM CUSTOMERS ORDER BY ADDRESS_ID DESC";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(cusID);
            while(rs.next()){
                ketqua = rs.getInt(1);
            }
            return ketqua;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int saveTotal(Order order) {
        try (Connection connection = DB_Util.getInstance().getConnection()){
            String sql = "UPDATE ORDERS SET TOTAL = (SELECT TOTALSUM FROM TOTAL_SUM TS WHERE TS.ORDER_ID = ORDERS.ORDER_ID)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int finalTotal(Order order) {
        try (Connection connection = DB_Util.getInstance().getConnection()){
            String sql = "UPDATE ORDERS SET TOTAL = (SELECT TOTALFINAL FROM TOTALFINAL TF WHERE TF.ORDER_ID = ORDERS.ORDER_ID)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateDiscount(Order order) {
        try (Connection connection = DB_Util.getInstance().getConnection()){
            String sql = "UPDATE ORDERS SET DISCOUNT_ID = (SELECT DISCOUNT_ID FROM DISCOUNT WHERE ORDERS.ORDER_DATE >= DISCOUNT.START_DATE AND ORDERS.ORDER_DATE <= DISCOUNT.END_DATE  )";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Order> showAll() {
        try (Connection connection = DB_Util.getInstance().getConnection()) {
            String sql = "SELECT O.* , C.FULL_NAME FROM ORDERS O JOIN CUSTOMERS C ON C.CUSTOMER_ID = O.CUSTOMER_ID";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("ORDER_ID");
                String name = resultSet.getString("NAME");
                String phone = resultSet.getString("PHONE_NUMBER");
                String address = resultSet.getString("DETAIL_ADDRESS");
                double total = resultSet.getDouble("TOTAL");
                Date orderDate = resultSet.getDate("ORDER_DATE");
                int customer_id = resultSet.getInt("CUSTOMER_ID");
                String fullName = resultSet.getString("FULL_NAME");
                int address_id = resultSet.getInt("ADDRESS_ID");
                int discount_id = resultSet.getInt("DISCOUNT_ID");
                orders.add(new Order(id,name,phone,address,total,orderDate,customer_id,fullName,address_id,discount_id));
            }

            return orders;
        } catch (Exception e) {
            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
