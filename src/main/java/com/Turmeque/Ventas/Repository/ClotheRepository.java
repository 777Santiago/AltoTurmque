package com.Turmeque.Ventas.Repository;

import com.Turmeque.Ventas.Entity.Clothe;
import com.Turmeque.Ventas.Repository.Crud.IClotheRepositoryCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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