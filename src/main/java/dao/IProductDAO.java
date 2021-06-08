package dao;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public void insertProduct(Product product) throws SQLException;

    public Product selectProduct(int id);

    public List<Product> selectAllProduct();

    public void deleteProduct(int id) throws SQLException;

    public void updateProduct(Product product) throws SQLException;
}
