package com.cfc282.restmiostore.entity.product;

public class Detail {
    private int id;
    private String category;
    private String size;
    private String weight;
    private String color;
    private String image;

    public Detail() {
    }

    public Detail(int id,String category, String size, String weight, String color, String image) {
        this.id = id;
        this.category = category;
        this.size = size;
        this.weight = weight;
        this.color = color;
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
}