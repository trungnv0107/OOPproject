package Dao;

import Model.Product;

import java.util.List;

public interface ProductDAO {
    int save(Product product);
    List<Product> showAll();
    int update(Product product, int id);
    boolean checkID(int id);
    int delete(int id);
}
