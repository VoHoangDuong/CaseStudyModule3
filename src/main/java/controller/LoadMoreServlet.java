package controller;

import dao.ProductDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoadMoreServlet", urlPatterns = "/loads")
public class LoadMoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int amount = Integer.parseInt(request.getParameter("exits"));
        ProductDAO productDAO = new ProductDAO();
        List<Product> list = productDAO.selectNextTop9(amount);
        PrintWriter out = response.getWriter();
        for (Product o : list) {
            out.println("<div class=\"product col-12 col-md-6 col-lg-4\">\n" +
                    "                        <div class=\"card\">\n" +
                    "                            <img class=\"card-img-top\" src ="+o.getImg()+" alt=\"Card\">\n" +
                    "                            <div class=\"card-body\">\n" +
                    "                                <h4 class=\"card-title show_txt\"><a href=\"details?pid="+o.getId()+" \" title=\"View Product\">"+o.getName()+"</a></h4>\n" +
                    "                                <p class=\"card-text show_txt\">"+o.getTitle()+"</p>\n" +
                    "                                <div class=\"row\">\n" +
                    "                                    <div class=\"col\">\n" +
                    "                                        <p class=\"btn btn-secondary btn-block\">"+o.getPrice()+" $</p>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"col\">\n" +
                    "                                        <a href=\"/cart.jsp\" class=\"btn btn-success btn-block\">Add to cart</a>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
