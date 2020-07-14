package model.employee;

import model.account.AccountCustomer;

/**
 *
 * @author Tran Chuyen
 */
public class SaleEmployee extends Employee{

    public SaleEmployee() {
        super();
    }

    public SaleEmployee(int id, AccountCustomer acount, String name, String phone, String address, String role) {
        super(id,acount, name, phone, address, role);
    }
     
    
}