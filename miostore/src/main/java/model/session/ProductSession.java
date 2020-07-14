package model.session;

import java.util.ArrayList;
import model.employee.IventoryEmployee;
import model.product.Product;

public class ProductSession {
    private int id;
    private IventoryEmployee inventoryEmployee;
    private ArrayList<Product> listProduct;

    public ProductSession() {
    }

    public ProductSession(int id, IventoryEmployee inventoryEmployee, ArrayList<Product> listProduct) {
        this.id = id;
        this.inventoryEmployee = inventoryEmployee;
        this.listProduct = listProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IventoryEmployee getInventoryEmployee() {
        return inventoryEmployee;
    }

    public void setInventoryEmployee(IventoryEmployee inventoryEmployee) {
        this.inventoryEmployee = inventoryEmployee;
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }
    
    
}