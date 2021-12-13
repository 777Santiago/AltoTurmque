/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.Controllers;

import com.Turmeque.VentasOnline.Entity.Order;
import com.Turmeque.VentasOnline.Services.OrderService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author johan
 */
@RestController
@RequestMapping("order")
@CrossOrigin(origins="*")
public class OrderController {
    /**
     * Declaracion de parametros
     */
    @Autowired
    private OrderService service;
    
    /**
     * Metodo para obtener todos las ordenes
     * @return 
     */
    @GetMapping("/all")
    public List<Order> findAllOrders(){
        return service.getOrders();
    }
    
    /**
     * MEtodo para obtener una orden por su ID
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable("id") Integer id)
    {
        return service.getOrder(id);
    }
    
       
    /**
     * Metodo para registrar un nuevo usuario     
     * @param order
     * @return 
     */
    
    @PostMapping("/new")
    public ResponseEntity newUser(@RequestBody Order order){
        service.newOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
      /**
     * Metodo para borrar un Usuario
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable ("id") Integer id){
        service.deleteOrder(id);
        return ResponseEntity.status(204).build();
    }
    /**
     * Metodo para obtener las ordenes por zona
     * @param zone
     * @return 
     */
    @GetMapping("zona/{zona}")
    public List<Order> getOrdersByZone(@PathVariable ("zona") String zone){
        return service.getOrdersByZone(zone);
    }
    
    /**
     * Metodo para actualizar una orden
     * @param order
     * @return 
     */
    @PutMapping("/update")
    public ResponseEntity updateOrder(@RequestBody Order order){
        service.updateOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    /**
     * Metodo para obtener las ordenes por usuario
     * @param id
     * @return 
     */
    @GetMapping("salesman/{id}")
    public List<Order> getOrdersByUser(@PathVariable ("id") Integer id){
        return service.getOrdersByUser(id);
    }
    
    /**
     * Metodo para obtner las ordenes por fecha y usuario
     * @param date
     * @param id
     * @return 
     * @throws java.text.ParseException 
     */
    @GetMapping("date/{date}/{id}")
     public List<Order> getOrdersByUser(@PathVariable ("date") String date, @PathVariable ("id") Integer id)throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOrder = formato.parse(date);
        return service.getOrdersByDateAndUser(dateOrder, id);
    }
    
     /**
      * Metodo para obtener las ordenes por estado y usuario
      * @param state
      * @param id
      * @return 
      */
    @GetMapping("state/{state}/{id}")    
    public List<Order> getOrdersByStateAndSalesman(@PathVariable ("state") String state,@PathVariable ("id") Integer id)
    {
        return service.getOrdersByStateAndSalesman(state, id);
    }    
    
}
