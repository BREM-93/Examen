package com.examen.cusca.CrudRelaciones.repository;

import com.examen.cusca.CrudRelaciones.entities.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customers, Long> {
}
