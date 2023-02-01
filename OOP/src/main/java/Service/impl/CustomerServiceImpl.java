package Service.impl;

import Dao.CustomerDAO;
import Dao.impl.CustomerDAOImpl;
import Model.Customer;
import Service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public boolean createCustomer(Customer customer) {
        return customerDAO.save(customer) > 0;
    }

    @Override
    public List<Customer> showAll() {
        return customerDAO.showAll();
    }
}
