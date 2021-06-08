package controller;

import dao.ProductDAO;
import model.Account;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddProductServlet", urlPatterns = "/add")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String img = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int category_id = Integer.parseInt(request.getParameter("category"));
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("accountS");
        int sid = account.getId();

        ProductDAO productDAO = new ProductDAO();
        Product product = new Product(name,img,price,title,description,category_id,sid);
        try {
            productDAO.insertProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("managers");
    }
}
