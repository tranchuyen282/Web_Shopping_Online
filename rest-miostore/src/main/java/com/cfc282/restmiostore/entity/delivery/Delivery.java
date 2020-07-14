/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfc282.restmiostore.entity.delivery;

import com.cfc282.restmiostore.entity.customer.Address;

/**
 *
 * @author Asus
 */
public class Delivery {
    private int id;
    private Address address;
    private DeliveryMethod method;
    private String receiverInfo;

    public Delivery(int id, Address address, DeliveryMethod method, String receiverInfo) {
        this.id = id;
        this.address = address;
        this.method = method;
        this.receiverInfo = receiverInfo;
    }


    public Delivery() {
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DeliveryMethod getMethod() {
        return method;
    }

    public void setMethod(DeliveryMethod method) {
        this.method = method;
    }

    public String getReceiverInfo() {
        return receiverInfo;
    }

    public void setReceiverInfo(String receiverInfo) {
        this.receiverInfo = receiverInfo;
    }
    
    
}
