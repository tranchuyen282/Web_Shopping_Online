package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.item.Item;
import model.product.Product;
import service.ItemService;
import serviceimpl.ItemServiceImpl;

/**
 *
 * @author Tran Chuyen
 */
@WebServlet(name="ViewItemController", urlPatterns={"/item"})
public class ViewItemController extends HttpServlet {
     private static final long serialVersionUID = 1L;

    public ViewItemController() {
        super();
    }
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String idItem = (String)request.getParameter("id");
        ItemService itemService = new ItemServiceImpl();
        Item item = itemService.getItemByID(Integer.parseInt(idItem));
        request.setAttribute("item", item);
        RequestDispatcher rd = request.getRequestDispatcher("/ViewItem.jsp");
	rd.forward(request, response);
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
