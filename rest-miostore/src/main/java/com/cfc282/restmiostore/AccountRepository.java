package com.cfc282.restmiostore;

import com.cfc282.restmiostore.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findAll();
}
