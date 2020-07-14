package com.cfc282.apistore.service;

import com.cfc282.apistore.entity.customer.Account;
import com.cfc282.apistore.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllUser() {
        return (List<Account>) accountRepository.findAll();
    }
}
