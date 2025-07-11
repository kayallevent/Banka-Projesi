package com.smartbank.bankapp.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super("Müşteri bulunamadı: " + id);
    }
}
