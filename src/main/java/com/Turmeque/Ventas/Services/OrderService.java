package com.Turmeque.Ventas.Services;

import com.Turmeque.Ventas.Entity.Order;
import com.Turmeque.Ventas.Repository.OrderRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    
    @Autowired
    private SequenceGeneratorService autoId;

    public Order newOrder (Order order){
        if(order.getId()==null){
            order.setId(autoId.generateSequence(Order.SEQUENCE_NAME));
            return repository.saveOrder(order);
        }else{
            Optional<Order> res= repository.findById(order.getId());
            if(res.isPresent())
            {
                return order;
            }else{
                return repository.saveOrder(order);             
            }
        }
    }
    
    public List<Order> getOrders()
    {
        return repository.getOrders();
    }
      
    public void deleteOrder(Integer id)
    {
      repository.deleteById(id);
    }
    
    public Optional<Order> getOrder(Integer id){
        return repository.findById(id);
    }
    
    public List<Order> getOrdersByZone(String zone){
        return repository.getOrdersByZone(zone);
    }
    
    public Order updateOrder (Order order){
        Optional<Order> res= repository.findById(order.getId());
        if(!res.isPresent())
            return order;
        
        if(order.getStatus()!=null)
            res.get().setStatus(order.getStatus());
        
        return repository.saveOrder(res.get());
    }

    public List<Order> getOrdersByUser(Integer id) {
        return repository.getOrdersByUsers(id);
    }

    public List<Order> getOrdersByDateAndUser(Date date, Integer Id) {
        return repository.getOrdersByDateAndUser(date, Id);
    }

    public List<Order> getOrdersByStateAndSalesman(String state, Integer Id) {
        return repository.getOrdersByStateAndSalesman(state, Id);
    }
}