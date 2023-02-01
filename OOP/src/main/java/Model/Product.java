package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private int productId;
    private String name, description;
    private Double price, discountPrice;
    private int stock, sold;
    private Date createDate;
    private String status;
    private Scanner sc = new Scanner(System.in);
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    public Product() {
    }

    public Product(int productId, String name, String description, Double price, Double discountPrice, int stock, int sold, Date createDate, String status) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountPrice = discountPrice;
        this.stock = stock;
        this.sold = sold;
        this.createDate = createDate;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discountPrice=" + discountPrice +
                ", stock=" + stock +
                ", sold=" + sold +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                '}';
    }
    public void input() throws ParseException {
        System.out.print("Enter product name: ");
        name = sc.nextLine();
        System.out.print("Enter product description: ");
        description = sc.nextLine();
        System.out.print("Enter product price: ");
        price = Double.parseDouble(sc.nextLine());
        System.out.print("Enter product discount: ");
        discountPrice = Double.parseDouble(sc.nextLine());
        System.out.print("Enter product stock: ");
        stock = Integer.parseInt(sc.nextLine());
        System.out.print("Enter product sold: ");
        sold = Integer.parseInt(sc.nextLine());
        System.out.println("Enter product date(yyyy-MM-dd): ");
        createDate = df.parse(sc.nextLine());
        System.out.println("Enter product status: ");
        status=sc.nextLine();
    }
    public void output(){
        System.out.printf("%10d %30s %30s %15.2f %15.2f %10d %10d %10s\n",productId,name,description,price,discountPrice,stock,sold,status);
    }
}
