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
public class BankCard extends Payment{
    private String fullName, cardNumber, effectiveDate;

    public BankCard() {
        super();
    }


    public BankCard(String fullName, String cardNumber, String effectiveDate) {
        this.fullName = fullName;
        this.cardNumber = cardNumber;
        this.effectiveDate = effectiveDate;
    }

    public BankCard(String fullName, String cardNumber, String effectiveDate, String method, int id) {
        super(method, id);
        this.fullName = fullName;
        this.cardNumber = cardNumber;
        this.effectiveDate = effectiveDate;
    }
    
    
     
}
