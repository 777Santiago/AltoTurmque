/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.Repository;


import com.Turmeque.VentasOnline.Entity.Clothe;
import com.Turmeque.VentasOnline.RepositoryCrud.IClotheRepositoryCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johan
 */
@Repository
public class ClotheRepository {
    @Autowired
    private IClotheRepositoryCrud clotheRepo;
    
    public List<Clothe> getClothes(){
        return clotheRepo.findAll();
    }
    
    public Clothe saveClothe(Clothe clothe){
        return clotheRepo.save(clothe);
    }
    
    public Optional<Clothe> findByReference(String reference){
        return clotheRepo.findByReference(reference);
    }
    
    public Long deleteByReference(String reference) {
        return clotheRepo.deleteClotheByReference(reference);
    }
}
