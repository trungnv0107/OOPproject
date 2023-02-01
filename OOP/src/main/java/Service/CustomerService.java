package Service;

import Model.Customer;

import java.util.List;

public interface CustomerService {
    boolean createCustomer(Customer customer);

    List<Customer> showAll();
}
