package com.cfc282.restmiostore.entity.cart;


import com.cfc282.restmiostore.entity.item.Item;

public class ItemCart {
    private int id;
    private Item item;
    private int quantity;

    public ItemCart() {
    }

    public ItemCart(int id, Item item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
    
}