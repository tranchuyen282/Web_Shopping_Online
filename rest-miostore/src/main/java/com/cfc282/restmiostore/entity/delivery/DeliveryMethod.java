/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfc282.restmiostore.entity.delivery;

/**
 *
 * @author Asus
 */
public class DeliveryMethod {
    private String deliveryName, note;
    private int id;

    public DeliveryMethod(String deliveryName, String note, int id) {
        this.deliveryName = deliveryName;
        this.note = note;
        this.id = id;
    }


    public DeliveryMethod() {
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }


    
    
    
}
