package com.CRUD_Projet_backend.controller;

import com.CRUD_Projet_backend.entity.Role;
import com.CRUD_Projet_backend.entity.Service;
import com.CRUD_Projet_backend.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ServiceController {
    //
    private final ServiceService serviceService;

    @PostMapping("/save")
    public Service saveService(@RequestBody Service service){
        return serviceService.addService(service);
    }
    //
    @GetMapping("")
    public List<Service> readAllServices(){
        return serviceService.getAllServices();
    }
    //
    @DeleteMapping("/delete/{id}")
    public void supprimerService(@PathVariable Long id){
        serviceService.deleteService(id);
    }
    //
    @GetMapping("/detail/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long id){
        Service service = serviceService.getServiceById(id);
        if(service==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(service);
    }
    //
    @PutMapping("/update/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long id, @RequestBody Service service){
        Service updateService = serviceService.updateService(id, service);
        if(updateService==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updateService);
    }
    //
}
