package com.Turmeque.Ventas.Repository.Crud;

import com.Turmeque.Ventas.Entity.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IOrderRepositoryCrud extends MongoRepository<Order,Integer>{
   @Query("{'salesMan.zone': ?0}") 
   public List<Order> getOrdersByZone(String zone);
   
   @Query("{'salesMan.id': ?0}")
   public List<Order> getOrdersBySalesman(Integer Id);
   
   @Query("{registerDay: ?0, 'salesMan.id': ?1 }")
   public List<Order> getOrdersByDateAndSalesman(Date date, Integer Id);
   
   @Query("{status: ?0, 'salesMan.id': ?1}")
   public List<Order> getOrdersByStateAndSalesman(String status, Integer Id);
}