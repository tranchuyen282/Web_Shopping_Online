package dao;

import model.customer.Customer;

public interface CustomerDAO {
    Customer getCustomerByIDAccount(int AccountID);

}