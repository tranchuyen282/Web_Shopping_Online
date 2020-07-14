package model.item;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Detail {
    private int id;
    private String provider;
    private String memory;
    private String model;
    private String color;
    private String image;

    public Detail() {
    }

    public Detail(int id, String provider, String memory, String model, String color, String image) {
        this.id = id;
        this.provider = provider;
        this.memory = memory;
        this.model = model;
        this.color = color;
        this.image = image;
    }
    
    
    
}