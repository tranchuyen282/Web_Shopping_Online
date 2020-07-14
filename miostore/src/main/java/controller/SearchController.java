package controller;

import model.item.Item;
import service.ItemService;
import serviceimpl.ItemServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SearchController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getParameter("searchname");
        if(name.contains("+")){
            name.replace("+"," ").trim();
        }
        ItemService itemService = new ItemServiceImpl();
        ArrayList<Item> listItem = itemService.getItemByName(name);
        request.setAttribute("listItem", listItem);
        RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
        rd.forward(request, response);
    }
}
