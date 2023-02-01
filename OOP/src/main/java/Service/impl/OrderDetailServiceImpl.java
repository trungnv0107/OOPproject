package Service.impl;

import Dao.OrderDetailDAO;
import Dao.impl.OrderDetailDAOImpl;
import Model.OrderDetail;
import Model.Product;
import Service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();

    @Override
    public boolean createOrderService(OrderDetail orderDetail) {
        return orderDetailDAO.save(orderDetail) > 0;
    }

    @Override
    public boolean updateStock(Product product) {
        return orderDetailDAO.updateStock(product) > 0;
    }

    @Override
    public boolean updateSold(Product product) {
        return orderDetailDAO.updateSold(product) > 0;
    }
}
