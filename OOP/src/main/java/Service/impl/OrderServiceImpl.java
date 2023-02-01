package Service.impl;

import Dao.OrderDAO;
import Dao.OrderDetailDAO;
import Dao.impl.OrderDAOImpl;
import Dao.impl.OrderDetailDAOImpl;
import Model.Order;
import Model.OrderDetail;
import Service.OrderService;

import java.util.List;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
    @Override
    public boolean createOrder(Order order) {
        return orderDAO.save(order) > 0;
    }

    @Override
    public boolean saveTotal(Order order) {
        return orderDAO.saveTotal(order) > 0;
    }

    @Override
    public boolean updateDiscount(Order order) {
        return orderDAO.updateDiscount(order) > 0;
    }

    @Override
    public boolean updateTotalFinal(Order order) {
        return orderDAO.finalTotal(order) > 0;
    }

    @Override
    public void showOrder() {
        List<Order> list = orderDAO.showAll();
        if (list.size() == 0) {
            System.out.println("No list yet");
        } else {
            System.out.printf("%10s %30s %15s %30s %10s %15s %15s %30s %15s %10s","Order ID","Name","Phone number","Detail address","Total","Order date","Customer ID","Customer name","Address ID","Discount ID");
            for (int i = 0; i < list.size(); i++) {

                list.get(i).output();

            }
            System.out.println();
            showOrderDetail(list);
        }
    }
    private void showOrderDetail(List<Order> list){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to see Order Detail(y/n):");
        String result = scanner.nextLine();
        while ("y".equalsIgnoreCase(result)) {
            System.out.print("Enter the order id you want to see details:");
            int chose = new Scanner(System.in).nextInt();
            if (chose > 0 && chose <= list.size()) {
                System.out.printf("%15s %10s %15s %15s %15s","Cart ID","Quantity","Total","Order ID", "Product ID");
                List<OrderDetail> orderDetailList = orderDetailDAO.showOrderDetail(chose);
                for (int i = 0; i < orderDetailList.size(); i++) {

                    orderDetailList.get(i).output();
                }
            } else {
                System.out.println("order id does not exist");
            }
            System.out.println();
            break;
        }
    }
}
