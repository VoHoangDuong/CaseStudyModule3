package controller;

import dao.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    public void init(){
        productDAO = new ProductDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listProduct(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws  ServletException,IOException{
        List<Product> productList = productDAO.selectTop9();
        request.setAttribute("productList",productList);

        List<Category> categoryList = productDAO.selectAllCategory();
        request.setAttribute("categoryList",categoryList);

        Product lastProduct = productDAO.getLastProduct();
        request.setAttribute("lastP",lastProduct);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
        dispatcher.forward(request,response);
    }
}
