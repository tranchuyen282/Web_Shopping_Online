package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.item.Item;
import model.product.*;
import service.ItemService;
import serviceimpl.ItemServiceImpl;
public class test {
    public static void main(String[] args) {
//        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
//        System.out.println(productDAOImpl.getProductByID(1, "book"));
//        ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
//       ArrayList<Item> listItem = itemDAOImpl.getAllItem();
////        System.out.println(listItem.size());
//        ItemService itemService = new ItemServiceImpl();
//        ArrayList<Item> listItem = itemService.getAllItem();
//        ArrayList<Product> listProduct = itemService.getProductOfItem(listItem);
//        System.out.println(listProduct.size());
//
//           for(int i = 0; i < 18;){
//               for(int x = 0; x < 5; x++){
//                   
//                   if(i < 18) System.out.print(i + " ");
//                   i++;
//               }
//               System.out.println("");
//           }

//        Map<String,String> infoCustomer = new HashMap<String, String>();
//        infoCustomer.put("ab","1");
//        infoCustomer.put("ab","2");
//        System.out.println(infoCustomer.get("ab"));
        ArrayList<Item> listItem = null;
        ItemDAOImpl  itemDaoImpl = new ItemDAOImpl();
        listItem = itemDaoImpl.getItemByType("Samsung");
        System.out.println(listItem.size());
    }

    
    
    
}