package com.cfc282.restmiostore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class RestMiostoreApplicationTests {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void contextLoads() {
        List<Account> listAccounts = accountRepository.findAll();
        System.out.println(listAccounts.size());

    }

}
