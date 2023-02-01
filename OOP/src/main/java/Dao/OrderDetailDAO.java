package Dao;

import Model.OrderDetail;
import Model.Product;

import java.util.List;

public interface OrderDetailDAO {
    int save(OrderDetail orderDetail);
    int orderID();
    double productPriceFinal(OrderDetail orderDetail);
    int updateStock(Product product);
    int updateSold(Product product);
    List<OrderDetail> showOrderDetail(int id);
}
