package controller;

import dao.ProductDAO;
import model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("user_name");
        String passWord = request.getParameter("pass");
        ProductDAO productDAO = new ProductDAO();
        Account account = productDAO.login(userName,passWord);
        if (account == null){
            request.setAttribute("text", "Error");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("accountS",account);
//            session.setMaxInactiveInterval(300);
            response.sendRedirect("/products");
        }
    }
}
