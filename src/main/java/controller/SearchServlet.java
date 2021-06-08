package controller;

import dao.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String keyword = request.getParameter("productName");
        ProductDAO productDAO = new ProductDAO();
        List<Product> list = productDAO.searchProductByName(keyword);
        request.setAttribute("productList",list);

        Product lastProduct = productDAO.getLastProduct();
        request.setAttribute("lastP",lastProduct);

        List<Category> categoryList = productDAO.selectAllCategory();
        request.setAttribute("categoryList",categoryList);

        request.setAttribute("keyword",keyword);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
