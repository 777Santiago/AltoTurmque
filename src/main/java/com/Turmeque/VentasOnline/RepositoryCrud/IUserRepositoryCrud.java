/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.RepositoryCrud;

import com.Turmeque.VentasOnline.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author johan
 */
public interface IUserRepositoryCrud extends MongoRepository<User,Integer>{

    @Query("{email: ?0}")
    public User findByEmail(String email);
    
    @Query("{email: ?0,password: ?1}")
    public User findUserAuthenticate (String email, String password);
    
}
