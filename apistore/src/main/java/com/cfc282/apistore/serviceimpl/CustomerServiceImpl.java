package com.cfc282.apistore.serviceimpl;

import com.cfc282.apistore.entity.customer.Customer;
import com.cfc282.apistore.repository.CustomerPepository;
import com.cfc282.apistore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerPepository customerPepository;

    @Override
    public ArrayList<Customer> getAllCustomer() {
        return (ArrayList<Customer>) customerPepository.findAll();
    }
}
