package com.cfc282.apistore.controller;

import com.cfc282.apistore.entity.customer.Account;
import com.cfc282.apistore.entity.customer.Customer;
import com.cfc282.apistore.service.AccountService;
import com.cfc282.apistore.serviceimpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/")
    public String index(Model model) {
//        ArrayList<Customer> customers = customerService.getAllCustomer();
//        List<Account> accounts = accountService.getAllUser();
//
//        for(Customer customer:customers){
//            System.out.println(customer);
//        }
        List<Account> accounts = accountService.getAllUser();
        for(Account account: accounts){
            System.out.println(account);
        }
        return "index";
    }
}
