/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.Services;


import com.Turmeque.VentasOnline.Repository.DatabaseSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 *
 * @author johan
 */
@Service
public class SequenceGeneratorService {
    @Autowired
    private DatabaseSequenceRepository sequence;

    public int generateSequence(String seqName) { 
        
        return sequence.generatorId(seqName);
    }   

  
}
