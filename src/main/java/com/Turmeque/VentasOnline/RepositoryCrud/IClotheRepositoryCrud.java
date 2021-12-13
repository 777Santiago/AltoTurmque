/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Turmeque.VentasOnline.RepositoryCrud;

import com.Turmeque.VentasOnline.Entity.Clothe;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author johan
 */
public interface IClotheRepositoryCrud extends MongoRepository<Clothe,Integer>{

    @Query("{reference: ?0}")
    public Optional<Clothe> findByReference(String reference);
    
    Long deleteClotheByReference(String reference);
}
