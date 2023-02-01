package Service;

import Model.Product;

import java.util.List;

public interface ProductService {
    boolean save(Product product);

    List<Product> showAll();

    boolean update(Product product, int id);

    boolean checkID(int id);

    boolean delete(int id);
}
