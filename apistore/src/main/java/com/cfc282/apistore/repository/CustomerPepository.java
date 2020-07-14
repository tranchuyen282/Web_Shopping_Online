package com.cfc282.apistore.repository;

import com.cfc282.apistore.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerPepository extends JpaRepository<Customer,Integer> {
}
