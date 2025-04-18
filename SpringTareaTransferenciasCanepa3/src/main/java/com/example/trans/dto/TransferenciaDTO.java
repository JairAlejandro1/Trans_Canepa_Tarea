package com.example.trans.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransferenciaDTO {

    @NotNull(message = "El ID de la cuenta origen es obligatorio")
    private Long cuentaOrigenId;

    @NotNull(message = "El ID de la cuenta destino es obligatorio")
    private Long cuentaDestinoId;

    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser positivo")
    private Double monto;

    // Constructores
    public TransferenciaDTO() {
    }

    public TransferenciaDTO(Long cuentaOrigenId, Long cuentaDestinoId, Double monto) {
        this.cuentaOrigenId = cuentaOrigenId;
        this.cuentaDestinoId = cuentaDestinoId;
        this.monto = monto;
    }

    // Getters y Setters
    public Long getCuentaOrigenId() {
        return cuentaOrigenId;
    }

    public void setCuentaOrigenId(Long cuentaOrigenId) {
        this.cuentaOrigenId = cuentaOrigenId;
    }

    public Long getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    public void setCuentaDestinoId(Long cuentaDestinoId) {
        this.cuentaDestinoId = cuentaDestinoId;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}