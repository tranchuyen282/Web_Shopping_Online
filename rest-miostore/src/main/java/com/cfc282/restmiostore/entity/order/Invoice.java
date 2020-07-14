/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfc282.restmiostore.entity.order;

/**
 *
 * @author Asus
 */
public class Invoice {
    private double subTotal, preTotal, total, feeExtra, discount;
    private int id;

    public Invoice() {
    }

    public Invoice(double subTotal, double preTotal, double total, double feeExtra, double discount, int id) {
        this.subTotal = subTotal;
        this.preTotal = preTotal;
        this.total = total;
        this.feeExtra = feeExtra;
        this.discount = discount;
        this.id = id;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getPreTotal() {
        return preTotal;
    }

    public void setPreTotal(double preTotal) {
        this.preTotal = preTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getFeeExtra() {
        return feeExtra;
    }

    public void setFeeExtra(double feeExtra) {
        this.feeExtra = feeExtra;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getId() {
        return id;
    }
    
    
}
