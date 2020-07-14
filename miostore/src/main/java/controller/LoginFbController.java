package controller;

import com.restfb.types.User;
import loginfacebook.RestFB;
import model.cart.Cart;
import model.customer.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginFbController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if(code == null || code.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("/login1.jsp");
            rd.forward(request, response);
        }else{
            String accessToken = RestFB.getToken(code);
            User user = RestFB.getUserInfo(accessToken);
            String[] name = user.getName().split(" ");
            String username = "";
            for(String s:name) username+=s;
            //check xem thang nay da dc luu trong db chua, neu chua thi luu, con co roi thi querry
            Customer customer = new Customer();
           //customer.setId(Integer.parseInt(user.getId()));
            customer.setName(username);
            HttpSession session = request.getSession();
            Cart cart = new Cart();
            //cart.setIdCustomer(customer.getId());
            session.setAttribute("customer",customer);
            session.setAttribute("cart", cart);
            Cookie userName = new Cookie("user", username);
            userName.setMaxAge(60*60*24*365);
            response.addCookie(userName);
            response.sendRedirect("home");
        }
    }
}
