package com.cfc282.restmiostore.entity.item;


import com.cfc282.restmiostore.entity.product.Product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private ItemRate itemRate;
    private String nameItem;
    private Double price;
    private String catogery;
    private int quantity;
    private int status;
    private int idProduct;

    public Item() {
    }

    public Item(int id, ItemRate itemRate, String nameItem, Double price, String catogery, int quantity, int status, int idProduct) {
        this.id = id;
        this.itemRate = itemRate;
        this.nameItem = nameItem;
        this.price = price;
        this.catogery = catogery;
        this.quantity = quantity;
        this.status = status;
        this.idProduct = idProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemRate getItemRate() {
        return itemRate;
    }

    public void setItemRate(ItemRate itemRate) {
        this.itemRate = itemRate;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCatogery() {
        return catogery;
    }

    public void setCatogery(String catogery) {
        this.catogery = catogery;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    public String getUrlImg(Product product){
        return product.getDetail().getImage();
    }
    
    public Map<String,String> getDetail(Product product){
        Map<String,String> detail = new HashMap<String, String>();
        
        detail.put("category",product.getDetail().getCategory());
        detail.put("size",product.getDetail().getSize());
        detail.put("weight",product.getDetail().getWeight());
        detail.put("color",product.getDetail().getColor());
      
        return detail;
    }
    

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", itemRate=" + itemRate + ", nameItem=" + nameItem + ", price=" + price + ", catogery=" + catogery + ", quantity=" + quantity + ", status=" + status + '}';
    }

   
    
    
    
}