package model.product;

import model.item.Detail;

public class Book extends Product{
    private String author;
    private String publisher;
    
    public Book() {
    }

    public Book(int id, String author, String publisher, Detail detail, String name, String provider, Double price) {
        super(id,detail, name, provider, price);
        this.author = author;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    
    
    
    
    
    
    
    

}