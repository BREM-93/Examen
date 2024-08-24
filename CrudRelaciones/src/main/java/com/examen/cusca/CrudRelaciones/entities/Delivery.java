package com.examen.cusca.CrudRelaciones.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;
    private String type;
    private String status;
    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true)
    private Order order;

    public Long getDeliveryId( ) {
        return deliveryId;
    }
    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }
    public String getType( ) {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getStatus( ) {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Order getOrder( ) {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
