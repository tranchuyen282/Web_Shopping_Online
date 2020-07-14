package com.cfc282.restmiostore.entity.product;

public class Computer extends Product{
    private String model;

    public Computer() {
    }

    public Computer(int id, String model, Detail detail, String name, String provider, Double price) {
        super(id,detail, name, provider, price);
        this.model = model;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    

}