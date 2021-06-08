package controller;

import dao.ProductDAO;
import model.Account;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerServlet", urlPatterns = "/managers")
public class ManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("accountS");
        int id = account.getId();

        ProductDAO productDAO = new ProductDAO();
        List<Product> list = productDAO.searchProductBySellID(id);

        List<Category> categoryList = productDAO.selectAllCategory();
        request.setAttribute("categoryList",categoryList);

        request.setAttribute("listP",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerProduct.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
