package controller;

import com.restfb.types.ads.Ad;
import ghn.api.ConvertAddressToAddressGHNService;
import ghn.api.GHNService;
import ghn.entity.AddressGHN;
import ghn.entity.MethodGHN;
import model.cart.Cart;
import model.customer.Address;
import model.customer.Customer;
import model.delivery.Delivery;
import model.item.Item;
import model.order.Order;
import service.ItemService;
import serviceimpl.ItemServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DeliveryMethodServlet extends HttpServlet {
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
            String selectedAddress= request.getParameter("selectAddress");

            Address address = customer.getAddress().get(Integer.parseInt(selectedAddress));
            Delivery delivery = new Delivery();
            delivery.setAddress(address);
            Order order = null;
            if(session.getAttribute("order") == null){
                Cart cart = (Cart) session.getAttribute("cart");
                order = new Order();
                order.setCart(cart);
                order.setDelivery(delivery);
                session.setAttribute("order", order);
            }else{
                order = (Order) session.getAttribute("order");
                order.setDelivery(delivery);
                session.setAttribute("order", order);
            }

            //tim nhung hinh thuc van chuyen phu hop, phi va thoi gian giao hang du kien
            AddressGHN addressGHN = ConvertAddressToAddressGHNService.convertToAddressGHN(address);
            GHNService ghnService = new GHNService();
            ArrayList<MethodGHN> listMethodGHN = ghnService.getMethodGHN(addressGHN);
            request.setAttribute("methodGHN",listMethodGHN);



            RequestDispatcher rd = request.getRequestDispatcher("/Delivery.jsp");
            rd.forward(request, response);
        }

    }
}
