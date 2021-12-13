package com.Turmeque.Ventas.Services;

import com.Turmeque.Ventas.Entity.Clothe;
import com.Turmeque.Ventas.Repository.ClotheRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClotheService {
    @Autowired
    private ClotheRepository repository;

    public List<Clothe> getClothes()
    {
        return repository.getClothes();
    }

    public Clothe newClothe(Clothe clothe) {
        Optional<Clothe> res= repository.findByReference(clothe.getReference());
        if(res.isPresent()){
           return clothe;  
        }else{                
           return repository.saveClothe(clothe);
        }       
    }

    public Clothe updateClothe(Clothe clothe){

        Optional<Clothe> res= repository.findByReference(clothe.getReference());
        if(!res.isPresent())
            return clothe;
        
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
    
    public Long deleteClothe(String reference) {
      return repository.deleteByReference(reference);
    }
    
    public Optional<Clothe> findByReference(String reference){
        return repository.findByReference(reference);
    }
}