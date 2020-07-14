package com.cfc282.restmiostore.repository;

import com.cfc282.restmiostore.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends JpaRepository<Customer,Integer>{
}
