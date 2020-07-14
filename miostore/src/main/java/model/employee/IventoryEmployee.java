package model.employee;

import model.account.AccountCustomer;

public class IventoryEmployee extends Employee{
    public IventoryEmployee() {
        super();
    }

    public IventoryEmployee(int id, AccountCustomer acount, String name, String phone, String address, String role) {
        super(id, acount, name, phone, address, role);
    }  
}