/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Turmeque.VentasOnline.RepositoryCrud;

import com.Turmeque.VentasOnline.Entity.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author johan
 */
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
