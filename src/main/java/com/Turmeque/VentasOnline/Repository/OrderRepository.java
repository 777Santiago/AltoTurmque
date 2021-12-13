/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.Repository;


import com.Turmeque.VentasOnline.Entity.Order;
import com.Turmeque.VentasOnline.RepositoryCrud.IOrderRepositoryCrud;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johan
 */
@Repository
public class OrderRepository {
   @Autowired
   private IOrderRepositoryCrud orderRepo; 
   
   public Order saveOrder(Order order)
   {
       return orderRepo.save(order);
   }
   
   public Optional<Order> findById(Integer id)
   {
       return orderRepo.findById(id);
   }  
   
     public List<Order> getOrders(){
        return orderRepo.findAll();
    }
     
     public void deleteById(Integer id) {
        orderRepo.deleteById(id);
    }
     
    public List<Order> getOrdersByZone(String zone){
        return orderRepo.getOrdersByZone(zone);
    }
    
    public List<Order> getOrdersByUsers(Integer id)
    {
        return orderRepo.getOrdersBySalesman(id);
    }
    
    public List<Order> getOrdersByDateAndUser(Date date, Integer Id)
    {
        return orderRepo.getOrdersByDateAndSalesman(date, Id);
    }
    
    public List<Order> getOrdersByStateAndSalesman(String state, Integer Id){
        return orderRepo.getOrdersByStateAndSalesman(state, Id);
    }
    
    
   
   
}
