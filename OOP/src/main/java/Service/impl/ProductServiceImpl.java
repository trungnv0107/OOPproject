package Service.impl;

import Dao.ProductDAO;
import Dao.impl.ProductDAOImpl;
import Model.Product;
import Service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();
    @Override
    public boolean save(Product product) {
        return productDAO.save(product) > 0;
    }

    @Override
    public List<Product> showAll() {
        return productDAO.showAll();
    }

    @Override
    public boolean update(Product product, int id) {
        return productDAO.update(product,id)>0;
    }

    @Override
    public boolean checkID(int id) {
        return productDAO.checkID(id);
    }

    @Override
    public boolean delete(int id) {
        return productDAO.delete(id) > 0;
    }
}
