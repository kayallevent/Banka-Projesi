package com.smartbank.bankapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;
import jakarta.validation.constraints.*;

public class CustomerDTO {

    @NotBlank(message = "Ad boş olamaz")
    private String ad;

    @NotBlank(message = "Soyad boş olamaz")
    private String soyad;

    @Email(message = "Geçerli bir email adresi girin")
    private String email;

    @NotNull(message = "Bakiye null olamaz")
    @Min(value = 0, message = "Bakiye negatif olamaz")
    private Double bakiye;

    // Getters & Setters

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBakiye() {
        return bakiye;
    }

    public void setBakiye(Double bakiye) {
        this.bakiye = bakiye;
    }
}
