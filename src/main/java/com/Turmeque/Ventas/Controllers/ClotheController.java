package com.Turmeque.Ventas.Controllers;

import com.Turmeque.Ventas.Entity.Clothe;
import com.Turmeque.Ventas.Services.ClotheService;
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
@RequestMapping("clothe")
@CrossOrigin(origins="*")
public class ClotheController {
    @Autowired
    private ClotheService service;

    @GetMapping("/all")
    public List<Clothe> findAllClothes(){
        return service.getClothes();
    }

    @PostMapping("/new")
    public ResponseEntity newClothe(@RequestBody Clothe clothe){
        service.newClothe(clothe);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateClothe(@RequestBody Clothe clothe){
        service.updateClothe(clothe);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

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