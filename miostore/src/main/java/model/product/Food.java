package model.product;

import model.item.Detail;

public class Food extends Product{
    private String type;

    public Food() {
    }

    public Food(int id, String type, Detail detail, String name, String provider, Double price) {
        super(id,detail, name, provider, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    

}