package Controller;

import Model.Customer;
import Model.Order;
import Model.OrderDetail;
import Model.Product;
import Service.CustomerService;
import Service.OrderDetailService;
import Service.OrderService;
import Service.ProductService;
import Service.impl.CustomerServiceImpl;
import Service.impl.OrderDetailServiceImpl;
import Service.impl.OrderServiceImpl;
import Service.impl.ProductServiceImpl;
import View.Menu;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void showTitle()
    {
        System.out.printf("%10s %30s %30s %15s %15s %10s %10s %10s\n","ID","Name","Description","Price","Discount percent","Stock","Sold","Status");
    }

    public static void showTitleCustomer()
    {
        System.out.printf("\n%15s %30s %30s %15s %15s\n","Customer ID","Full name","Email","Phone number","Address ID");
    }
    static Scanner sc = new Scanner(System.in);
    private static final ProductService productService = new ProductServiceImpl();
    private static final CustomerService customService = new CustomerServiceImpl();
    private static final OrderService orderService = new OrderServiceImpl();
    private static final OrderDetailService orderDetailService = new OrderDetailServiceImpl();
    public static void main(String[] args) throws ParseException {
        int menu;
        do{
            menu = Menu.getInstance().mainMenu();
            switch(menu){
                case 1:
                    int productMenu;
                    do{
                        productMenu = Menu.getInstance().productManagerMenu();
                        switch (productMenu){
                            case 1:
                                System.out.println("___CREATE PRODUCT___");
                                Product product = new Product();
                                product.input();
                                productService.save(product);
                                System.out.println("\t ADD PRODUCT SUCCESS!!!");
                                break;
                            case 2:
                                List<Product> products = productService.showAll();
                                showTitle();
                                for(Product product1 : products){
                                    product1.output();
                                }
                                break;
                            case 3:
                                System.out.println("___UPDATE PRODUCT___");
                                System.out.println("Enter ID product you want to update: ");
                                int id = Integer.parseInt(sc.nextLine());
                                if(productService.checkID(id) == true){
                                    Product product1 = new Product();
                                    product1.input();
                                    productService.update(product1, id);
                                    System.out.println("\t UPDATE SUCCESS!!!");
                                }
                                else System.out.println("\t THERE IS HAS NO THIS PRODUCT ID!");
                                break;
                            case 4:
                                System.out.println("___DELETE PRODUCT___");
                                System.out.print("Enter ID product you want to delete: ");
                                int id1 = Integer.parseInt(sc.nextLine());
                                if(productService.checkID(id1)==true)
                                {
                                    productService.delete(id1);
                                    System.out.println("\t DELETE SUCCESS!!!");
                                }
                                else System.out.println("\tTHERE IS HAS NO THIS PRODUCT ID!");
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println();
                                System.out.println("Only choice 0 -> 4");
                                break;
                        }
                    }while(productMenu != 0);
                    break;
                case 2:
                    Product product = new Product();
                    Customer customer = new Customer();
                    Order order = new Order();
                    OrderDetail orderDetail = new OrderDetail();
                    customer.input();
                    customService.createCustomer(customer);
                    order.input();
                    orderService.createOrder(order);
                    String ans;
                    do{
                        orderDetail.input();
                        orderDetailService.createOrderService(orderDetail);
                        orderDetailService.updateStock(product);
                        orderDetailService.updateSold(product);
                        System.out.println("Do you want to continue? Y/N");
                        ans = sc.nextLine();
                    }while (!ans.equals("N") && !ans.equals("n"));
                    orderService.saveTotal(order);
                    orderService.updateDiscount(order);
                    orderService.updateTotalFinal(order);
                    break;
                case 3:
                    orderService.showOrder();
                    break;
                case 4:
                    List<Customer> customerList = customService.showAll();
                    showTitleCustomer();
                    for(Customer customer1 : customerList){
                        customer1.output();
                    }
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Only choice 0 -> 4");
                    break;
            }
        }while (menu != 0);
    }
}
