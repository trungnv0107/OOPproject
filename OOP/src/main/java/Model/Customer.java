package Model;

import Service.AddressService;
import Service.impl.AddressServiceImpl;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Customer {
    public static void showTitle()
    {
        System.out.printf("%15s %30s %30s %15s %15s %10s \n","Address ID","City","District","Sub District","Postal Code","Delivery Fee");
    }
    private static final AddressService addressService = new AddressServiceImpl();

    private int customerId;
    private String fullName, email;
    private String phoneNumber;
    private int addressId;

    private Scanner sc = new Scanner(System.in);
    public Customer() {
    }
    public Customer(String fullName) {
        this.fullName = fullName;
    }
    public Customer(int customerId, String fullName, String email, String phoneNumber, int addressId) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressId = addressId;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", addressId=" + addressId +
                '}';
    }
    public void input() throws ParseException {
        System.out.println("--Customer Information--");
        System.out.print("Customer name:");
        fullName = sc.nextLine();
        System.out.print("Customer email:");
        email = sc.nextLine();
        System.out.print("Customer phone number:");
        phoneNumber = sc.nextLine();
        List<Address> addresses = addressService.showAll();
        showTitle();
        for (Address address : addresses) {
            address.output();
        }
        System.out.print("Customer address id:");
        addressId = sc.nextInt();
    }

    public void output()
    {
        System.out.printf("\n%15d %30s %30s %15s %15d",customerId,fullName,email,phoneNumber,addressId);
    }
}
