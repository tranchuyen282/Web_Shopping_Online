package model.item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.product.Product;

@Data
public class Item implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String nameItem;
    private int price;
    private int quantity;
    private String category;
    private int status;
    private ItemRate itemRate;
    private Detail detail;

    public Item() {
    }

    public Item(int id, String nameItem, int price, int quantity, String category, int status, ItemRate itemRate, Detail detail) {
        this.id = id;
        this.nameItem = nameItem;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.status = status;
        this.itemRate = itemRate;
        this.detail = detail;
    }
}