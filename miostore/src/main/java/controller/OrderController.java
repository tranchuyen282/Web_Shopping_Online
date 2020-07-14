package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.customer.Customer;

/**
 *
 * @author Tran Chuyen
 */
public class OrderController extends HttpServlet {
   
    private static final long serialVersionUID = 1L;

    public OrderController() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         Customer customer = null;
        HttpSession session = request.getSession();
        if(session.getAttribute("customer") != null){
            customer = (Customer)session.getAttribute("customer");
        }
        //System.out.println(customer);
        if(customer == null){
            RequestDispatcher rd = request.getRequestDispatcher("/login");
            rd.forward(request, response);
        }
        else{
            RequestDispatcher rd = request.getRequestDispatcher("/order.jsp");
            rd.forward(request, response);
        }
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
