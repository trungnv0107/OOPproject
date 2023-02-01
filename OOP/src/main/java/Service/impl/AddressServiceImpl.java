package Service.impl;

import Dao.AddressDAO;
import Dao.impl.AddressDAOImpl;
import Model.Address;
import Service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDAO addressDAO = new AddressDAOImpl();
    @Override
    public List<Address> showAll() {
        return addressDAO.showAll();
    }
}
