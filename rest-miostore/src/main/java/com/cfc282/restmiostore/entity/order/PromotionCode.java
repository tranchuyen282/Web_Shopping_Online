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
public class PromotionCode {
    private String code, initData, expDate;
    private float discount;
    private int id;

    public PromotionCode() {
    }

    public PromotionCode(String code, String initData, String expDate, float discount, int id) {
        this.code = code;
        this.initData = initData;
        this.expDate = expDate;
        this.discount = discount;
        this.id = id;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInitData() {
        return initData;
    }

    public void setInitData(String initData) {
        this.initData = initData;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    
}
