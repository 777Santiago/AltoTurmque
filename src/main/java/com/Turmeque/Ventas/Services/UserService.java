package com.Turmeque.Ventas.Services;

import com.Turmeque.Ventas.Entity.User;
import com.Turmeque.Ventas.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private SequenceGeneratorService autoId;
    
    public List<User> getUsers() {
        return repository.getUsers();
    }
      
    public User newUser(User user) {
        if(user.getId()== null){
            boolean resultUser= emailExist(user.getEmail());
            if(resultUser){
              return user;  
            }else{            
              user.setId(autoId.generateSequence(User.SEQUENCE_NAME));
              return repository.saveUser(user);
            }           
        }else{
            Optional<User> res= repository.findById(user.getId());
            if(res.isPresent()){
              return user;  
            }else{                
                boolean resultUser= emailExist(user.getEmail());
                if(resultUser){
                    return user;  
                }else{
                    return repository.saveUser(user);
                }           
            }           
        }
    }

    public boolean emailExist(String email){
        User resultUser= repository.findByEmail(email);
        return resultUser != null;     
    }

    public User userAuthenticate(String email, String password){
        User userResult = repository.findUserAuthenticate(email, password);
        if(userResult!=null){
            return userResult;
        }else{
            return new User ();
        }        
    }

    public User updateUser(User user){
        Optional<User> res= repository.findById(user.getId());
        if(!res.isPresent())
            return user;

        return repository.saveUser(user);
    }
    
    public String deleteUser(Integer id) {
        repository.deleteById(id);
        return "Usuario removido" + id;
    }

    public Optional<User> findById(Integer id) {
        return repository.findById(id);
    }
}