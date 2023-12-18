package com.CRUD_Projet_backend.service;

import com.CRUD_Projet_backend.entity.Customer;
import com.CRUD_Projet_backend.entity.User;
import com.CRUD_Projet_backend.entity.Service;
import com.CRUD_Projet_backend.repository.CustomerRepository;
import com.CRUD_Projet_backend.repository.ServiceRepository;
import com.CRUD_Projet_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class UserService {
    //
    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;

    public User postUser(User user){
        return  userRepository.save(user);
    }
    //
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    //
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    //
    public User getOneUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    //
    public User updateUser(Long id, User user){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User existingUser = optionalUser.get();
            existingUser.setPrenom(user.getPrenom());
            existingUser.setNom(user.getNom());
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setContact(user.getContact());
            return userRepository.save(existingUser);
        }
        return null;
    }
    //
    public List<Service> selectDataService(){
        return serviceRepository.findAll();
    }
    //

}
