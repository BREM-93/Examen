package com.examen.cusca.CrudRelaciones.service;

import com.examen.cusca.CrudRelaciones.entities.Category;
import com.examen.cusca.CrudRelaciones.entities.Delivery;

import java.util.List;

public interface DeliveryService {
    List<Delivery> getAllDeliveries();
    Delivery getDeliveryById(Long id);
    Delivery createDelivery(Delivery delivery);
    Delivery updateDelivery(Long id, Delivery delivery);
    void deleteDelivery(Long id);
}
