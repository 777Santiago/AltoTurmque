/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.Repository;

import com.Turmeque.VentasOnline.Entity.User;
import com.Turmeque.VentasOnline.RepositoryCrud.IUserRepositoryCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johan
 */
@Repository
public class UserRepository {
    @Autowired
    private IUserRepositoryCrud userRepo;
    
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    
    public User findByEmail(String email){
        return userRepo.findByEmail(email);
    }
    
    public User saveUser(User user){
        return userRepo.save(user);
    }
    
    public Optional<User> findById(Integer id){
        return userRepo.findById(id);
    }

    public User findUserAuthenticate(String email, String password) {
        return userRepo.findUserAuthenticate(email, password);
    }

    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }    
}
