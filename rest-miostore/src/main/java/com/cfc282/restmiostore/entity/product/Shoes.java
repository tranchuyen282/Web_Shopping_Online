package com.cfc282.restmiostore.entity.product;

public class Shoes extends Product{
    private String gender;

    public Shoes() {
    }

    public Shoes(int id, String gender, Detail detail, String name, String provider, Double price) {
        super(id,detail, name, provider, price);
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
}