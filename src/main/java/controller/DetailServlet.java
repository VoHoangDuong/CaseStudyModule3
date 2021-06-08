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

@WebServlet(name = "DetailServlet", urlPatterns = "/details")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("pid"));
        ProductDAO productDAO = new ProductDAO();
        Product product = null;
        try {
            product = productDAO.getProductById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("detail",product);

        Product lastProduct = productDAO.getLastProduct();
        request.setAttribute("lastP",lastProduct);

        List<Category> categoryList = productDAO.selectAllCategory();
        request.setAttribute("categoryList",categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("detail.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
