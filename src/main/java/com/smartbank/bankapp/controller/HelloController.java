package com.smartbank.bankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Uygulama başarılı şekilde çalışıyor!";
    }
}
