package controller;

import dao.ProductDAO;
import model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignUpServlet", urlPatterns = "/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("full_name");
        String passWord = request.getParameter("password");
        String re_pass = request.getParameter("comfirm_password");
        if (!passWord.equals(re_pass)){
            response.sendRedirect("login.jsp");
        }else {
            ProductDAO productDAO = new ProductDAO();
            Account account = productDAO.checkAccountExist(userName);
            if (account == null){
                // dc sign up
                productDAO.signup(userName,passWord);
                response.sendRedirect("products");
            }else {
                // trả về login
                request.setAttribute("alert", "Error");
                response.sendRedirect("login.jsp");
            }
        }
    }
}
