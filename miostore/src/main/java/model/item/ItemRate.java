package model.item;

public class ItemRate {
    private int id;
    private String comment;
    private int star;

    public ItemRate() {
    }

    public ItemRate(int id, String comment, int star) {
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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
    
    

}