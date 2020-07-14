/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfc282.restmiostore.entity.order;

import com.cfc282.restmiostore.entity.cart.Cart;
import com.cfc282.restmiostore.entity.delivery.Delivery;

public class Order {
    private String orderDate;
    private Delivery delivery;
    private PromotionCode promotionCode;
    private OrderStatus orderStatus;
    private Cart cart;
    private int id;

    public Order(String orderDate, Delivery delivery, PromotionCode promotionCode, OrderStatus orderStatus, Cart cart, int id) {
        this.orderDate = orderDate;
        this.delivery = delivery;
        this.promotionCode = promotionCode;
        this.orderStatus = orderStatus;
        this.cart = cart;
        this.id = id;
    }

    public Order() {
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public PromotionCode getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(PromotionCode promotionCode) {
        this.promotionCode = promotionCode;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    
    
}
