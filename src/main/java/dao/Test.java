package dao;

import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        ProductDAO productDAO = new ProductDAO();
        int count = productDAO.getTotalProduct();
        System.out.println(count);
    }
}
