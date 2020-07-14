package controller;

import ghn.api.ConvertAddressToAddressGHNService;
import ghn.api.GHNService;
import ghn.entity.AddressGHN;
import ghn.entity.MethodGHN;
import model.cart.Cart;
import model.customer.Customer;
import model.item.Item;
import model.order.Order;
import model.product.Product;
import service.ItemService;
import serviceimpl.ItemServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class SelectAddressController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SelectAddressController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            Order order = null;
            if(session.getAttribute("order") == null){
                Cart cart = (Cart) session.getAttribute("cart");
                order = new Order();
                order.setCart(cart);
                session.setAttribute("order", order);
            }
            RequestDispatcher rd = request.getRequestDispatcher("Address1.jsp");
            rd.forward(request, response);
        }
    }
}
