package com.Turmeque.Ventas.Repository;


import com.Turmeque.Ventas.Entity.Order;
import com.Turmeque.Ventas.Repository.Crud.IOrderRepositoryCrud;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    
   public List<Order> getOrdersByDateAndUser(Date date, Integer Id) {
       return orderRepo.getOrdersByDateAndSalesman(date, Id);
   }
    
   public List<Order> getOrdersByStateAndSalesman(String state, Integer Id){
       return orderRepo.getOrdersByStateAndSalesman(state, Id);
   }
}