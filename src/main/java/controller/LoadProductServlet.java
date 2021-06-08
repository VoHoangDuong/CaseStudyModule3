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

@WebServlet(name = "LoadProductServlet", urlPatterns = "/load")
public class LoadProductServlet extends HttpServlet {
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
        List<Category> categoryList = productDAO.selectAllCategory();
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("detail",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Edit.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
