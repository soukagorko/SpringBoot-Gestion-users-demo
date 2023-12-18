package com.CRUD_Projet_backend.service;

import com.CRUD_Projet_backend.entity.Role;
import com.CRUD_Projet_backend.entity.Service;
import com.CRUD_Projet_backend.repository.RoleRepository;
import com.CRUD_Projet_backend.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService {
    //
    private final ServiceRepository serviceRepository;

    public Service addService(Service service){
        return  serviceRepository.save(service);
    }
    //
    public List<Service> getAllServices(){
        return serviceRepository.findAll();
    }
    //
    public void deleteService(Long id){
        serviceRepository.deleteById(id);
    }
    //
    public Service getServiceById(Long id){
        return serviceRepository.findById(id).orElse(null);
    }
    //
    public Service updateService(Long id, Service service){
        Optional<Service> optionalService = serviceRepository.findById(id);
        if(optionalService.isPresent()){
            Service existingService = optionalService.get();
            existingService.setNomservice(service.getNomservice());
            existingService.setSigleservice(service.getSigleservice());
            existingService.setContactservice(service.getContactservice());
            existingService.setDescservice(service.getDescservice());
            return serviceRepository.save(existingService);
        }
        return null;
    }
    //
}
