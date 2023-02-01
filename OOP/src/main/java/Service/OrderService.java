package Service;

import Model.Order;

public interface OrderService {
    boolean createOrder(Order order);
    boolean saveTotal(Order order);
    boolean updateDiscount(Order order);
    boolean updateTotalFinal(Order order);
    void showOrder();
}
