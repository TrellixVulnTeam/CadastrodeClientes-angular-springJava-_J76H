package com.oquedadinheiro.customer.controller;

import com.oquedadinheiro.customer.models.Customer;
import com.oquedadinheiro.customer.repository.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private Customers customers;

    @GetMapping
    public List<Customer> get(){
        return customers.findAll();
    }

    @PostMapping
    public Customer create(@Valid @RequestBody Customer customer){
        return customers.save(customer);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Long> deletePost(@PathVariable(value = "id") Long id) {
        Customer customerId = customers.findById(id).orElseThrow();
        customers.delete(customerId);
        return null;
    }
}
