/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.Services;

import com.Turmeque.VentasOnline.Entity.Clothe;
import com.Turmeque.VentasOnline.Repository.ClotheRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class ClotheService {
    @Autowired
    private ClotheRepository repository;
    
    /**
     * Metodo para obtener todos los productos
     * @return 
     */
      public List<Clothe> getClothes()
    {
        return repository.getClothes();
    }
    
  /**
     * Metodo para registrar un nuevo producto
     * @param clothe
     * @return 
   */
    public Clothe newClothe(Clothe clothe)
    {
        Optional<Clothe> res= repository.findByReference(clothe.getReference());
        if(res.isPresent()){
           return clothe;  
        }else{                
           return repository.saveClothe(clothe);
        }       
    }
    
    /**
     * Metodo para actualizar un producto
     * @param clothe
     * @return 
     */
    public Clothe updateClothe(Clothe clothe){
    
        //Verificamos la existencia del producto
        Optional<Clothe> res= repository.findByReference(clothe.getReference());
        if(!res.isPresent()){
            return clothe;
        }
        
        if(clothe.getReference()!=null)
            res.get().setReference(clothe.getReference());
        
        if(clothe.getCategory()!=null)
            res.get().setCategory(clothe.getCategory());
                
        if(clothe.getSize()!=null)
            res.get().setSize(clothe.getSize());
   
        if(clothe.getDescription()!=null)
            res.get().setDescription(clothe.getDescription());
        
        if(clothe.getPrice()!=0)
            res.get().setPrice(clothe.getPrice());        
        
        if(clothe.getPhotography()!=null)
            res.get().setPhotography(clothe.getPhotography());               
               
        return repository.saveClothe(res.get());
    }
    
    /**
     * Metodo para borrar un producto
     * @param reference
     * @return 
     */
    public Long deleteClothe(String reference)
    {
      return repository.deleteByReference(reference);
    }
    
    public Optional<Clothe> findByReference(String reference){
        return repository.findByReference(reference);
    }
}
