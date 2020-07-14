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

import ghn.api.ConvertAddressToAddressGHNService;
import ghn.api.GHNService;
import ghn.entity.AddressGHN;
import ghn.entity.MethodGHN;
import model.cart.Cart;
import model.customer.Customer;
import model.delivery.Delivery;
import model.item.Item;
import model.order.Order;
import model.product.Product;
import service.ItemService;
import serviceimpl.ItemServiceImpl;

/**
 *
 * @author Tran Chuyen
 */
public class CheckOutServlet extends HttpServlet {
   
    private static final long serialVersionUID = 1L;

    public CheckOutServlet() {
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
        
        if(customer == null){
            RequestDispatcher rd = request.getRequestDispatcher("/login");
            rd.forward(request, response);
        }
        else{
            Order order = (Order) session.getAttribute("order");
            Delivery delivery =order.getDelivery();

            AddressGHN addressGHN = ConvertAddressToAddressGHNService.convertToAddressGHN(delivery.getAddress());
            GHNService ghnService = new GHNService();
            ArrayList<MethodGHN> listMethodGHN = ghnService.getMethodGHN(addressGHN);

            String selectedMethod= (String)request.getParameter("deliverymethod");
            delivery.setDeliveryMethod(listMethodGHN.get(Integer.parseInt(selectedMethod)));
            order.setDelivery(delivery);
            session.setAttribute("order",order);

            ItemService itemService = new ItemServiceImpl();
            ArrayList<Item> listItem = itemService.getAllItem();
            request.setAttribute("listItem", listItem);
            
            RequestDispatcher rd = request.getRequestDispatcher("Payment2.jsp");
            rd.forward(request, response);
        }
        
        
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String paymentMethod = (String) request.getParameter("thanhtoan");
        HttpSession session = request.getSession();
//        Cart cart = (Cart) session.getAttribute("cart");
//        Cart cart1 = new Cart();
//        session.setAttribute("cart",cart1);
        if(paymentMethod.equals("cod")){
            //Order order = (Order) session.getAttribute("order");
            ItemService itemService = new ItemServiceImpl();
            ArrayList<Item> listItem = itemService.getAllItem();
            request.setAttribute("listItem", listItem);
            RequestDispatcher rd = request.getRequestDispatcher("OrderDetail.jsp");
            rd.forward(request, response);
        }
//        String url = "home?suc="+paymentMethod;
//        response.sendRedirect("orders.jsp");
    }

   
    

}
