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
public class Cash extends Payment{
    private String currentcy;

    public Cash() {
        super();
    }

    public Cash(String currentcy, String method, int id) {
        super(method, id);
        this.currentcy = currentcy;
    }

    

    public String getCurrentcy() {
        return currentcy;
    }

    public void setCurrentcy(String currentcy) {
        this.currentcy = currentcy;
    }
    
}
