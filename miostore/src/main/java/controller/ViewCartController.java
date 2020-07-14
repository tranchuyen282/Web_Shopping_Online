package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.customer.Customer;
import model.item.Item;
import model.product.Product;
import service.ItemService;
import serviceimpl.ItemServiceImpl;

public class ViewCartController extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Customer customer = null;
        HttpSession session = request.getSession();
        if(session.getAttribute("customer") != null){
            customer = (Customer)session.getAttribute("customer");
        }
        if(customer == null){
            RequestDispatcher rd = request.getRequestDispatcher("/login");
            rd.forward(request, response);
        }
        else{
            ItemService itemService = new ItemServiceImpl();
            ArrayList<Item> listItem = itemService.getAllItem();
            request.setAttribute("listItem", listItem);
            RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
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
