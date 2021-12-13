package com.Turmeque.Ventas.Repository.Crud;

import com.Turmeque.Ventas.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IUserRepositoryCrud extends MongoRepository<User,Integer>{

    @Query("{email: ?0}")
    public User findByEmail(String email);
    
    @Query("{email: ?0,password: ?1}")
    public User findUserAuthenticate (String email, String password);
}