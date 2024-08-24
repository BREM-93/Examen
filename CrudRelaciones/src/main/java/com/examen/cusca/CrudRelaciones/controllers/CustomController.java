package com.examen.cusca.CrudRelaciones.controllers;

import com.examen.cusca.CrudRelaciones.entities.Customers;
import com.examen.cusca.CrudRelaciones.service.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public List<Customers> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomersById(@PathVariable Long id){
        Customers customers = customerService.getCustomerById(id);
        return ResponseEntity.ok(customers);
    }
    @PostMapping
    public ResponseEntity<Customers> createuser(@RequestBody Customers customers){
        Customers createdCustomer = customerService.createCustomer(customers);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable Long id, @RequestBody Customers customers){
        Customers updateCustomer = customerService.updateCustomer(id, customers);
        return ResponseEntity.ok(customers);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
    customerService.deleteCustomer(id);
    return ResponseEntity.noContent().build();
    }
}
