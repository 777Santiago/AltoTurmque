/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.Repository;

import com.Turmeque.VentasOnline.Entity.DatabaseSequence;
import com.Turmeque.VentasOnline.RepositoryCrud.IDatabaseSequenceRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johan
 */
@Repository
public class DatabaseSequenceRepository {

    @Autowired
    private IDatabaseSequenceRepositoryCrud sequenceRepo;

    public int generatorId(String sequenceName) {

        DatabaseSequence sequence = new DatabaseSequence();
        sequence = sequenceRepo.findBySequenceName(sequenceName);
        int idSequence = sequence.getSequence();
        idSequence += 1;
        sequence.setSequence(idSequence);
        sequenceRepo.save(sequence);
        return idSequence;
    }
}
