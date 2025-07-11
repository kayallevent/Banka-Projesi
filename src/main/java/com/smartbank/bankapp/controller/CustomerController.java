package com.smartbank.bankapp.controller;


import jakarta.validation.Valid;
import com.smartbank.bankapp.dto.CustomerDTO;
import com.smartbank.bankapp.model.Customer;
import com.smartbank.bankapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.smartbank.bankapp.exception.CustomerNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Tüm müşterileri listele
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // ID ile müşteri getir
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return ResponseEntity.ok(customer);
    }


    // Yeni müşteri oluştur
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setAd(customerDTO.getAd());
        customer.setSoyad(customerDTO.getSoyad());
        customer.setEmail(customerDTO.getEmail());
        customer.setBakiye(customerDTO.getBakiye());

        Customer saved = customerRepository.save(customer);
        return ResponseEntity.ok(saved);
    }


    // Müşteri sil
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

    // Müşteri güncelle
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody CustomerDTO customerDTO) {

        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setAd(customerDTO.getAd());
                    customer.setSoyad(customerDTO.getSoyad());
                    customer.setEmail(customerDTO.getEmail());
                    customer.setBakiye(customerDTO.getBakiye());
                    Customer updated = customerRepository.save(customer);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}


