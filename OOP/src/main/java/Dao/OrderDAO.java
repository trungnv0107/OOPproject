package Dao;

import Model.Order;

import java.util.List;

public interface OrderDAO {
    int save(Order order);
    int customerID();
    String phoneNumber();
    int addressID();
    int saveTotal(Order order);
    int finalTotal(Order order);
    int updateDiscount(Order order);
    List<Order> showAll();
}
