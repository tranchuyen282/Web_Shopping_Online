package model.product;

import model.item.Detail;

public class Product {
    private int id;
    private Detail detail;
    private String name;
    private String provider;
    private Double price;

    public Product() {
    }

    public Product(int id,Detail detail, String name, String provider, Double price) {
        this.id = id;
        this.detail = detail;
        this.name = name;
        this.provider = provider;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }
    
    
    

    @Override
    public String toString() {
        return "Product{" + "detail=" + detail + ", name=" + name + ", provider=" + provider + ", price=" + price + '}';
    }
    
    
}