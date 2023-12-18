package com.CRUD_Projet_backend.service;

import com.CRUD_Projet_backend.entity.Customer;
import com.CRUD_Projet_backend.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    //
    private final CustomerRepository customerRepository;

    public Customer postCustomer(Customer customer){
        return  customerRepository.save(customer);
    }
    //
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }
    //
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
    //
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);
    }
    //
    public Customer updateCustomer(Long id, Customer customer){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setName(customer.getName());
            existingCustomer.setPhone(customer.getPhone());
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

}
