package dao;

import model.Account;
import model.Category;
import model.Item;
import model.Product;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/shop?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "duong6046237";

    public Connection connection = null;
    public PreparedStatement statement;
    public ResultSet resultSet = null;
    Product product = null;
    Category category = null;
    Account account = null;

    protected Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        String query = "insert into product(name,img,price,title,description,category_id,sell_ID) \n" +
                "values(?,?,?,?,?,?,?);";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,product.getName());
            statement.setString(2,product.getImg());
            statement.setDouble(3,product.getPrice());
            statement.setString(4,product.getTitle());
            statement.setString(5,product.getDescription());
            statement.setInt(6,product.getCategory_id());
            statement.setInt(7,product.getSell_ID());
            statement.executeUpdate();
        }catch (SQLException se){
            printSQLException(se);
        }
    }

    @Override
    public Product selectProduct(int id) {
        return null;
    }

    @Override
    public List<Product> selectAllProduct() {
        List<Product> productList = new ArrayList<>();
        String query = "select * from product;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getLong("price");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                product = new Product(id,name,img,price,title,description);
                productList.add(product);
            }
        }catch (SQLException se){
            printSQLException(se);
        }
        return productList;
    }

    public List<Product> selectAllProductByCategory(int cid) {
        List<Product> productList = new ArrayList<>();
        String query = "select * from product where category_id = ?;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,cid);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getLong("price");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                product = new Product(id,name,img,price,title,description);
                productList.add(product);
            }
        }catch (SQLException se){
            printSQLException(se);
        }
        return productList;
    }

    public List<Product> searchProductByName(String keyword) {
        List<Product> productList = new ArrayList<>();
        String query = "select * from product where `name` like ?;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getLong("price");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                product = new Product(id,name,img,price,title,description);
                productList.add(product);
            }
        }catch (SQLException se){
            printSQLException(se);
        }
        return productList;
    }

    public List<Product> searchProductBySellID(int pid) {
        List<Product> list = new ArrayList<>();
        String query = "select*from product where sell_ID = ?;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, pid);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getLong("price");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                product = new Product(id,name,img,price,title,description);
                list.add(product);
            }
        }catch (SQLException se){
            printSQLException(se);
        }
        return list;
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        String query = "delete from product where id = ?;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException se){
            printSQLException(se);
        }
    }

    public Product getProductById(int id) throws SQLException, ServletException,IOException {
        String query = "select * from product where id = ?;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                product = new Product(id,name,img,price,title,description);
            }
        }catch (SQLException se){
            printSQLException(se);
        }
        return product;
    }

    public Account login(String user, String pass){
        String query = "select * from account\n" +
                "where userName = ?\n" +
                "and pass = ?;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,user);
            statement.setString(2,pass);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("pass");
                int isSell = resultSet.getInt("isSell");
                int isAdmin = resultSet.getInt("isAdmin");
                account = new Account(id,userName,passWord,isSell,isAdmin);
                return account;
            }
        }catch (SQLException se){
            printSQLException(se);
        }
        return null;
    }

    public Account checkAccountExist(String user){
        String query = "select * from account\n" +
                "where userName = ?;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,user);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("pass");
                int isSell = resultSet.getInt("isSell");
                int isAdmin = resultSet.getInt("isAdmin");
                account = new Account(id,userName,passWord,isSell,isAdmin);
                return account;
            }
        }catch (SQLException se){
            printSQLException(se);
        }
        return null;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        String query = "update product set name = ?, img = ?, price = ?, title = ?, `description` = ?, category_id = ?\n" +
                "where id = ?;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,product.getName());
            statement.setString(2,product.getImg());
            statement.setDouble(3,product.getPrice());
            statement.setString(4,product.getTitle());
            statement.setString(5,product.getDescription());
            statement.setInt(6,product.getCategory_id());
            statement.setInt(7,product.getId());
            statement.executeUpdate();
        }catch (SQLException se){
            printSQLException(se);
        }
    }

    public void signup(String user, String pass){
        String query = "insert into account(userName,pass,isSell,isAdmin) \n" +
                "values (?,?,0,0);";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,user);
            statement.setString(2,pass);
            statement.executeUpdate();
        }catch (SQLException se){
            printSQLException(se);
        }
    }

    public List<Category> selectAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        String query = "select * from category;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("category_name");
                category = new Category(id,name);
                categoryList.add(category);
            }
        }catch (SQLException se){
            printSQLException(se);
        }
        return categoryList;
    }

    public Product getLastProduct(){
        String query = "select * from product order by id desc limit 1;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                product = new Product(id,name,img,price,title,description);
            }
        }catch (SQLException se){
            printSQLException(se);
        }
        return product;
    }
    // Đếm số lượng sản phẩm trong DB
    public int getTotalProduct(){
        String query = "select count(*) from product;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int count = resultSet.getInt(1);
                return count;
            }
        }catch (SQLException se){
            printSQLException(se);
        }
        return 0;
    }
    public List<Product> selectTop9(){
        List<Product> productList = new ArrayList<>();
        String query = "select * from product limit 9;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Product product = new Product(id,name,img,price,title,description);
                productList.add(product);
            }
        }catch (SQLException se){
            printSQLException(se);
        }
        return productList;
    }

    public List<Product> selectNextTop9(int amount){
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM product\n" +
                "ORDER BY id\n" +
                "LIMIT ?,9;";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1,amount);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Product product = new Product(id,name,img,price,title,description);
                productList.add(product);
            }
        }catch (SQLException se){
            printSQLException(se);
        }
        return productList;
    }

//    public List<Item> findItem(){
//        List<Item> itemList = new ArrayList<>();
//        String query = "select p.id, p.`name` ,p.img, p.price, i.quantity\n" +
//                "from item i\n" +
//                "inner join product p\n" +
//                "on i.id_item = p.id";
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement(query);
//            resultSet = statement.executeQuery();
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String img = resultSet.getString("img");
//                double price = resultSet.getDouble("price");
//                int quantity = resultSet.getInt("quantity");
//                Item item = new Item(id,name,img,price,quantity);
//                itemList.add(item);
//            }
//        }catch (SQLException se){
//            printSQLException(se);
//        }
//        return itemList;
//    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
