package com.Turmeque.Ventas.Repository.Crud;

import com.Turmeque.Ventas.Entity.Clothe;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IClotheRepositoryCrud extends MongoRepository<Clothe,Integer>{

    @Query("{reference: ?0}")
    public Optional<Clothe> findByReference(String reference);
        Long deleteClotheByReference(String reference);
}