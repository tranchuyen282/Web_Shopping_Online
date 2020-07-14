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
public class EditCartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditCartController() {
        super();
    }
   
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       String idItem = (String)request.getParameter("idItem");
       Integer quantity = Integer.parseInt((String)request.getParameter("quantity"));
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
            ItemService itemService = new ItemServiceImpl();
            Item item = itemService.getItemByID(Integer.parseInt(idItem));
            
            cart.editItem(item, quantity);
            
            //System.out.println(cart.getLineItem().get(idItem));
           
            // add to card and session
            session.setAttribute("cart", cart);

            response.sendRedirect(request.getContextPath()+"/viewcart");
        }
    } 
    

}
