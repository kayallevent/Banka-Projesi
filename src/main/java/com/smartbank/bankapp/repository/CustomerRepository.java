package com.smartbank.bankapp.repository;

import com.smartbank.bankapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
