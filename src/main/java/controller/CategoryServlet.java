package controller;

import dao.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Deque;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("cid"));
        ProductDAO productDAO = new ProductDAO();
        List<Product> productList = productDAO.selectAllProductByCategory(id);
        request.setAttribute("productList",productList);

        List<Category> categoryList = productDAO.selectAllCategory();
        request.setAttribute("categoryList",categoryList);

        Product lastProduct = productDAO.getLastProduct();
        request.setAttribute("lastP",lastProduct);

        request.setAttribute("tag",id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
