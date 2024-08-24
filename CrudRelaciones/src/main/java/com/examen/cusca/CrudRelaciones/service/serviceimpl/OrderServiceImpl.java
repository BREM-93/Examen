package com.examen.cusca.CrudRelaciones.service.serviceimpl;

import com.examen.cusca.CrudRelaciones.entities.Customers;
import com.examen.cusca.CrudRelaciones.entities.Order;
import com.examen.cusca.CrudRelaciones.repository.OrderRepository;
import com.examen.cusca.CrudRelaciones.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) this.orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return this.orderRepository.findById(id).get();
    }

    @Override
    public Order createOrder(Order order) {
        order.setOrderDate(order.getOrderDate());
        this.orderRepository.save(order);
        return null;
    }
    @Override
    public Order updateOrder(Long id, Order order) {
        Order existingCustomer = orderRepository.findById(id).orElse(null);
        if (existingCustomer !=null){
            existingCustomer.setOrderDate(order.getOrderDate());
            existingCustomer.setDelivery(order.getDelivery());
            existingCustomer.setCustomers(order.getCustomers());
            return orderRepository.save(existingCustomer);
        }
        return null;
    }
    @Override
    public void deleteOrder(Long id) {
        this.orderRepository.deleteById(id);
    }
}
