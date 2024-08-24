package com.examen.cusca.CrudRelaciones.service;

import com.examen.cusca.CrudRelaciones.entities.Customers;

import java.util.List;

public interface CustomerService {
    List<Customers> getAllCustomers();
    Customers getCustomerById(Long id);
    Customers createCustomer(Customers customers);
    Customers updateCustomer(Long id, Customers customers);
    void deleteCustomer(Long id);
}
