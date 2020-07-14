package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import md5.MD5Library;
import model.cart.Cart;
import model.customer.Customer;
import service.CustomerService;
import serviceimpl.CustomerServiceImpl;




/**
 *
 * @author Tran Chuyen
 */
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MD5Library md5 = new MD5Library();

    public LoginController() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/login1.jsp");
        rd.forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // get request parameters for username and password;
        String user = request.getParameter("username");
        String pass = md5.encrypt(request.getParameter("password"));
        Customer customer = null;
        CustomerService customerService = new CustomerServiceImpl();
        customer = customerService.getCustomer(user, pass);

        if(customer != null){
            // set cookie and session
            HttpSession session = request.getSession();
            Cart cart = new Cart();
            cart.setIdCustomer(customer.getId());
            session.setAttribute("customer",customer);
            session.setAttribute("cart", cart);
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(60*60*24*365);
            response.addCookie(userName);
            
            // create or get cart in db and add to session
            
            
            
            if(request.getAttribute("refereritem") != null){
                String referer = (String) request.getAttribute("referer");
                response.sendRedirect(referer);
            }else{
                String referer = request.getHeader("Referer");
                if(referer.contains("login")){
                referer = "home";
            }
            response.sendRedirect(referer);
            }
            
            
            
            
        }else{
            response.sendRedirect("login?err=1");
        }
       
    }


}
