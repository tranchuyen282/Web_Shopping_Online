package com.cfc282.restmiostore.entity.item;

public class ItemRate {
    private int id;
    private String comment;
    private String star;

    public ItemRate() {
    }

    public ItemRate(int id, String comment, String star) {
        this.id = id;
        this.comment = comment;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }
    
    

}