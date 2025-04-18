package com.example.trans.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "ID autogenerado de la cuenta")
    private Long id;

    @Schema(description = "Nombre del propietario de la cuenta", example = "Juan Pérez", required = true)
    private String propietario;

    @Schema(description = "Saldo actual de la cuenta", example = "1000.0", required = true)
    private Double saldo;

    // Constructores
    public Cuenta() {
    }

    public Cuenta(Long id, String propietario, Double saldo) {
        this.id = id;
        this.propietario = propietario;
        this.saldo = saldo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}