package model.product;

import model.item.Detail;

public class Clothes extends Product{
    private String gender;

    public Clothes() {
    }

    public Clothes(int id, String gender, Detail detail, String name, String provider, Double price) {
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