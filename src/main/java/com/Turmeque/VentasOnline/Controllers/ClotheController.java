/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.Controllers;

import com.Turmeque.VentasOnline.Entity.Clothe;
import com.Turmeque.VentasOnline.Services.ClotheService;
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
@RequestMapping("clothe")
@CrossOrigin(origins="*")
public class ClotheController {
    @Autowired
    private ClotheService service;
    /**
     * Metodo para obtener todos los productos
     * @return 
     */
    @GetMapping("/all")
    public List<Clothe> findAllClothes(){
        return service.getClothes();
    }
    
    /**
     * Metodo para registrar un nuevo producto
     * @param clothe
     * @return 
     */
    @PostMapping("/new")
    public ResponseEntity newClothe(@RequestBody Clothe clothe){
        service.newClothe(clothe);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    /**
     * Metodo para actualizar producto
     * @param clothe
     * @return 
     */
    @PutMapping("/update")
    public ResponseEntity updateClothe(@RequestBody Clothe clothe){
        service.updateClothe(clothe);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    /**
     * Metodo para borrar un producto
     * @param reference
     * @return 
     */
    @DeleteMapping("/{reference}")
    public ResponseEntity deleteClothe(@PathVariable ("reference") String reference){
        service.deleteClothe(reference);
        return ResponseEntity.status(204).build();
    }
    
    @GetMapping("/{reference}")
    public Optional<Clothe> findByReference(@PathVariable ("reference") String reference){
       return service.findByReference(reference);               
    }
    
    
}
