/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Turmeque.VentasOnline.RepositoryCrud;

import com.Turmeque.VentasOnline.Entity.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author johan
 */
public interface IDatabaseSequenceRepositoryCrud extends MongoRepository<DatabaseSequence,String>{
    
    @Query("{_id: ?0}")
    public DatabaseSequence findBySequenceName(String sequenceName);
}
