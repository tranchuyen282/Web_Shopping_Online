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
import model.item.Item;
import model.product.Product;
import service.ItemService;
import serviceimpl.ItemServiceImpl;

public class HomController extends HttpServlet {
   
    private static final long serialVersionUID = 1L;

    public HomController() {
        super();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //get item ra....
        ItemService itemService = new ItemServiceImpl();
        ArrayList<Item> listItem = itemService.getAllItem();
        request.setAttribute("listItem", listItem);
        RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
	    rd.forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
    }


}
