package com.cfc282.restmiostore.entity.employee;


import com.cfc282.restmiostore.Account;

public class IventoryEmployee extends Employee{
    public IventoryEmployee() {
        super();
    }

    public IventoryEmployee(int id, Account acount, String name, String phone, String address, String role) {
        super(id, acount, name, phone, address, role);
    }  
}