package Model;

import Service.AddressService;
import Service.impl.AddressServiceImpl;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Order extends  Customer{
    public static void showTitle()
    {
        System.out.printf("%15s %30s %30s %15s %15s %10s \n","Address ID","City","District","Sub District","Postal Code","Delivery Fee");
    }
    private static final AddressService addressService = new AddressServiceImpl();

    private int orderId;
    private String name;
    private String phoneNumber;
    private String detailAddress;
    private double total;
    private Date orderDate;
    private int customerId, addressId, discountId;
    private Scanner sc = new Scanner(System.in);
    public Order() {
    }

    public Order(int orderId, String name, String phoneNumber, String detailAddress, Double total, Date orderDate, int customerId, String fullName, int addressId, int discountId) {
        super(fullName);
        this.orderId = orderId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.detailAddress = detailAddress;
        this.total = total;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.addressId = addressId;
        this.discountId = discountId;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", detailAddress='" + detailAddress + '\'' +
                ", total=" + total +
                ", orderDate=" + orderDate +
                ", customerId=" + customerId +
                ",customerName="+ super.getFullName()+
                ", addressId=" + addressId +
                ", discountId=" + discountId +
                '}';
    }
    public void input() throws ParseException {
        System.out.println("--Order Information--");
        System.out.print("Enter order name: ");
        name = sc.nextLine();
        System.out.print("Enter detail address: ");
        detailAddress = sc.nextLine();

    }
    public void output()
    {
        System.out.printf("\n%10d %30s %15s %30s %10s %15s %15d %30s %15s %10s",orderId,name,phoneNumber,detailAddress,total,orderDate,customerId,getFullName(),addressId,discountId);

    }
}
