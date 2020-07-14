package model.product;

import model.item.Detail;

public class Bag extends Product{
    private String model;

    public Bag() {
    }

    public Bag(String model, int id, Detail detail, String name, String provider, Double price) {
        super(id, detail, name, provider, price);
        this.model = model;
    }
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    
}