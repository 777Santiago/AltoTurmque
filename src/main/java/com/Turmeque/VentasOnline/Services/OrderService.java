/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.Services;

import com.Turmeque.VentasOnline.Entity.Order;
import com.Turmeque.VentasOnline.Repository.OrderRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    
    @Autowired
    private SequenceGeneratorService autoId;
    
    /**
     * Metodo para registrar una Orden
     * @param order
     * @return 
     */
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
    
      /**
     * Metodo para obtener todas las ordenes
     * @return 
     */
      public List<Order> getOrders()
    {
        return repository.getOrders();
    }
      
     /**
     * Metodo para borrar una orden
     * @param id     
     */
    public void deleteOrder(Integer id)
    {
      repository.deleteById(id);
    }
    
    
    /**
     * Metodo para obtener una order
     * @param id
     * @return 
     */
    public Optional<Order> getOrder(Integer id){
        return repository.findById(id);
    }
    
    /**
     * Metodo para obtener una listado de order por zona
     * @param zone
     * @return 
     */
    public List<Order> getOrdersByZone(String zone){
        return repository.getOrdersByZone(zone);
    }
    
     /**
     * Metodo para actualizar una orden
     * @param order
     * @return 
     */
    public Order updateOrder (Order order){
       
        Optional<Order> res= repository.findById(order.getId());
        if(!res.isPresent()){
            return order;
        }
        
        if(order.getStatus()!=null){
            res.get().setStatus(order.getStatus());
        }
        
        return repository.saveOrder(res.get());      
          
    }
    
    /**
     * Obtener las ordenes por usuario
     * @param id
     * @return 
     */
    public List<Order> getOrdersByUser(Integer id)
    {
        return repository.getOrdersByUsers(id);
    }
    
    /**
     * Metodo para obtener las ordenes por fecha y usuario
     * @param date
     * @param Id
     * @return 
     */
    public List<Order> getOrdersByDateAndUser(Date date, Integer Id)
    {
        return repository.getOrdersByDateAndUser(date, Id);
    }
    
     /**
     * Metodo para obtener las ordenes por estado y usuario
     * @param state
     * @param Id
     * @return 
     */
    public List<Order> getOrdersByStateAndSalesman(String state, Integer Id)
    {
        return repository.getOrdersByStateAndSalesman(state, Id);
    }
    
    
    
}
