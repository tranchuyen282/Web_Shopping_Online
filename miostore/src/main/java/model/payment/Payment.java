/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.payment;

/**
 *
 * @author Asus
 */
public class Payment {
    private String method;
    private int id;

    public Payment() {
    }

    public Payment(String method, int id) {
        this.method = method;
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getId() {
        return id;
    }

}
