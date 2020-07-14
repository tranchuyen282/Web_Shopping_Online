package service;

import model.customer.Customer;

public interface CustomerService {
    Customer getCustomer(String username, String password);
}