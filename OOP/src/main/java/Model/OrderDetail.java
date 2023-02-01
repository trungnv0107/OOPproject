package Model;

import Service.ProductService;
import Service.impl.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class OrderDetail {
    public static void showTitle()
    {
        System.out.printf("%15s %30s %30s %15s %15s %10s %10s %10s\n","Product ID","Name","Description","Price","Discount percent","Stock","Sold","Status");
    }
    private static final ProductService productService = new ProductServiceImpl();

    private int cartId, quantity;
    private double total;
    private int orderId, productId;
    private Scanner sc = new Scanner(System.in);
    public OrderDetail() {
    }

    public OrderDetail(int cartId, int quantity, Double total, int orderId, int productId) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.total = total;
        this.orderId = orderId;
        this.productId = productId;
    }

    public OrderDetail(int quantity, Double total, int orderId, int productId) {
        this.quantity = quantity;
        this.total = total;
        this.orderId = orderId;
        this.productId = productId;
    }
    public OrderDetail(int cartId, int quantity, double total, int productId) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.total = total;
        this.productId = productId;
    }
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "cardId=" + cartId +
                ", quantity=" + quantity +
                ", total=" + total +
                ", orderId=" + orderId +
                ", productId=" + productId +
                '}';
    }
    public void input() {

        List<Product> products = productService.showAll();
        showTitle();
        for (Product product : products) {
            product.output();
        }

        System.out.print("Enter product id: ");
        productId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter quantity: ");
        quantity = Integer.parseInt(sc.nextLine());

    }
    public void output()
    {
        System.out.printf("\n%15d %10d %15.2f %15d %15d",cartId,quantity,total,orderId, productId);

    }
}
