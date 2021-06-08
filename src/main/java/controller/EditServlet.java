package controller;

import dao.ProductDAO;
import model.Account;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditServlet", urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String img = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int category_id = Integer.parseInt(request.getParameter("category"));
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product(id,name,img,price,title,description,category_id);
        try {
            productDAO.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("managers");
    }
}
