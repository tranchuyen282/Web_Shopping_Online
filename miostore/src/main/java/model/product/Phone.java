package model.product;

import model.item.Detail;

public class Phone extends Product{
    private String memory;
    private String model;

    public Phone() {
    }

    public Phone(int id, String memory, String model, Detail detail, String name, String provider, Double price) {
        super(id,detail, name, provider, price);
        this.memory = memory;
        this.model = model;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
}