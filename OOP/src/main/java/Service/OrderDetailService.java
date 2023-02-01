package Service;

import Model.OrderDetail;
import Model.Product;

public interface OrderDetailService {
    boolean createOrderService(OrderDetail orderDetail);
    boolean updateStock(Product product);
    boolean updateSold(Product product);
}
