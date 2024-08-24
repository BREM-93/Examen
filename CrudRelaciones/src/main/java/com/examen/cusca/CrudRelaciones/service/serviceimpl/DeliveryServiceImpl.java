package com.examen.cusca.CrudRelaciones.service.serviceimpl;

import com.examen.cusca.CrudRelaciones.entities.Category;
import com.examen.cusca.CrudRelaciones.entities.Delivery;
import com.examen.cusca.CrudRelaciones.entities.Product;
import com.examen.cusca.CrudRelaciones.repository.DeliveryRepository;
import com.examen.cusca.CrudRelaciones.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;
    @Override
    public List<Delivery> getAllDeliveries() {
        return (List<Delivery>) this.deliveryRepository.findAll();
    }
    @Override
    public Delivery getDeliveryById(Long id) {
        return this.deliveryRepository.findById(id).get();
    }
    @Override
    public Delivery createDelivery(Delivery delivery) {
        delivery.setDeliveryId(delivery.getDeliveryId());
        this.deliveryRepository.save(delivery);
        return null;
    }
    @Override
    public Delivery updateDelivery(Long id, Delivery delivery) {
        Delivery existingDelivery = deliveryRepository.findById(id).orElse(null);
        if (existingDelivery !=null){
            existingDelivery.setType(delivery.getType());
            existingDelivery.setStatus(delivery.getStatus());
            return deliveryRepository.save(existingDelivery);
        }
        return null;
    }
    @Override
    public void deleteDelivery(Long id) {
        this.deliveryRepository.deleteById(id);
    }
}
