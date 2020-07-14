package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.cart.Cart;
import model.customer.Customer;
import model.item.Item;
import model.product.Product;
import service.ItemService;
import serviceimpl.ItemServiceImpl;

/**
 *
 * @author Tran Chuyen
 */
public class AddCartController extends HttpServlet {
     private static final long serialVersionUID = 1L;

    public AddCartController() {
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
            Cart cart = (Cart) session.getAttribute("cart");
            String url = "item?id=";
            String idItem = (String)request.getParameter("id");
            url += idItem ;
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            
            ItemService itemService = new ItemServiceImpl();
            Item item = itemService.getItemByID(Integer.parseInt(idItem));
            cart.addItem(item, quantity);

            // add to card and session
            session.setAttribute("cart", cart);
            url+= "&add=1";
            response.sendRedirect(url);
        }
    } 

    
    

}
