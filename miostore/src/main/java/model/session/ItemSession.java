package model.session;

import java.util.ArrayList;
import model.employee.SaleEmployee;
import model.item.Item;

public class ItemSession {
    private int id;
    private SaleEmployee saleEmployee;
    private ArrayList<Item> listItem;

    public ItemSession() {
    }

    public ItemSession(int id, SaleEmployee saleEmployee, ArrayList<Item> listItem) {
        this.id = id;
        this.saleEmployee = saleEmployee;
        this.listItem = listItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SaleEmployee getSaleEmployee() {
        return saleEmployee;
    }

    public void setSaleEmployee(SaleEmployee saleEmployee) {
        this.saleEmployee = saleEmployee;
    }

    public ArrayList<Item> getListItem() {
        return listItem;
    }

    public void setListItem(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }
    
    
    
}