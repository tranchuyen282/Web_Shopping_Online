package model.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.customer.Customer;
import model.item.Item;

public class Cart {
    private int id;
    private int idCustomer;
    private Map<String,Integer> lineItem ;

    public Cart() {
        lineItem = new HashMap<String, Integer>();
    }

    public Cart(int id, int idCustomer, Map<String, Integer> lineItem) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.lineItem = lineItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Map<String, Integer> getLineItem() {
        return lineItem;
    }

    public void setLineItem(Map<String, Integer> lineItem) {
        this.lineItem = lineItem;
    }
    
    public Map<String,String> getInfoCustomer(Customer customer){
        Map<String,String> infoCustomer = new HashMap<String, String>();
        
        
        return infoCustomer;
    }
    
    public void addItem(Item item, int quantity){
        if(lineItem.get(String.valueOf(item.getId())) == null){
            lineItem.put(String.valueOf(item.getId()),quantity);
        }else{
            quantity += lineItem.get(String.valueOf(item.getId()));
            lineItem.put(String.valueOf(item.getId()), quantity);
        }
    }
    
    public void deleteItem(Item item){
        lineItem.remove(String.valueOf(item.getId()));
    }
    
    public void editItem(Item item, int quantity){
        lineItem.put(String.valueOf(item.getId()),quantity);
    }

    
}