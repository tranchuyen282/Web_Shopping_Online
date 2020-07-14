package com.cfc282.restmiostore.entity.employee;

import com.cfc282.restmiostore.Account;

public class Employee {
    private int id;
    private Account acount;
    private String name;
    private String phone;
    private String address;
    private String role;

    public Employee() {
    }

    public Employee(int id,Account acount, String name, String phone, String address, String role) {
        this.id = id;
        this.acount = acount;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public Account getAcount() {
        return acount;
    }

    public void setAcount(Account acount) {
        this.acount = acount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" + "acount=" + acount + ", name=" + name + ", phone=" + phone + ", address=" + address + ", role=" + role + '}';
    }
    
    
}
