package com.oquedadinheiro.customer.repository;

import com.oquedadinheiro.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customers extends JpaRepository<Customer, Long> {

}
