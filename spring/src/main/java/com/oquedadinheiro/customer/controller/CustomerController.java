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
    public Customer post(@Valid @RequestBody Customer customer){
        return customers.save(customer);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Long> delete(@PathVariable(value = "id") Long id) {
        Customer customerId = customers.findById(id).orElseThrow();
        customers.delete(customerId);
        return ResponseEntity.ok(id);
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<Customer> put(@PathVariable(value = "id") Long id
            ,@Valid @RequestBody Customer updateCustomer){
        Customer customer = customers.findById(id).orElseThrow();
        customer.setEmail(updateCustomer.getEmail());
        customer.setName(updateCustomer.getName());
        customer.setPassword(updateCustomer.getPassword());
        customer.setUsername(updateCustomer.getUsername());
        final Customer update = customers.save(customer);
        return ResponseEntity.ok(update);
    }
}
