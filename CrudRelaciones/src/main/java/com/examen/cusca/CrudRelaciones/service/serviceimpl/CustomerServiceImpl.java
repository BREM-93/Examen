package com.examen.cusca.CrudRelaciones.service.serviceimpl;

import com.examen.cusca.CrudRelaciones.entities.Customers;
import com.examen.cusca.CrudRelaciones.repository.CustomerRepository;
import com.examen.cusca.CrudRelaciones.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customers> getAllCustomers(){
        return (List<Customers>) this.customerRepository.findAll();
    }
    @Override
    public Customers getCustomerById(Long id) {
        return this.customerRepository.findById(id).get();
    }

    @Override
    public Customers createCustomer(Customers customers) {
        customers.setName(customers.getName());
        this.customerRepository.save(customers);
        return null;
    }

    @Override
    public Customers updateCustomer(Long id, Customers customers) {
        Customers existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer !=null){
            existingCustomer.setName(customers.getName());
            existingCustomer.setEmail(customers.getEmail());
            existingCustomer.setAddress(customers.getAddress());
            return customerRepository.save(existingCustomer);
        }
        return null;
    }
    @Override
    public void deleteCustomer(Long id) {
        this.customerRepository.deleteById(id);
    }
}
