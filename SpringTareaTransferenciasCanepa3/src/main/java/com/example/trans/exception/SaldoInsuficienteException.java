package com.example.trans.exception;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}