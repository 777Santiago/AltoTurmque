package com.Turmeque.Ventas.Controllers;

import com.Turmeque.Ventas.Entity.Order;
import com.Turmeque.Ventas.Services.OrderService;
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

@RestController
@RequestMapping("order")
@CrossOrigin(origins="*")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/all")
    public List<Order> findAllOrders(){
        return service.getOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable("id") Integer id)
    {
        return service.getOrder(id);
    }

    @PostMapping("/new")
    public ResponseEntity newUser(@RequestBody Order order){
        service.newOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable ("id") Integer id){
        service.deleteOrder(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("zona/{zona}")
    public List<Order> getOrdersByZone(@PathVariable ("zona") String zone){
        return service.getOrdersByZone(zone);
    }

    @PutMapping("/update")
    public ResponseEntity updateOrder(@RequestBody Order order){
        service.updateOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("salesman/{id}")
    public List<Order> getOrdersByUser(@PathVariable ("id") Integer id){
        return service.getOrdersByUser(id);
    }

    @GetMapping("date/{date}/{id}")
     public List<Order> getOrdersByUser(@PathVariable ("date") String date, @PathVariable ("id") Integer id)throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOrder = formato.parse(date);
        return service.getOrdersByDateAndUser(dateOrder, id);
    }

    @GetMapping("state/{state}/{id}")    
    public List<Order> getOrdersByStateAndSalesman(@PathVariable ("state") String state,@PathVariable ("id") Integer id) {
        return service.getOrdersByStateAndSalesman(state, id);
    }
}