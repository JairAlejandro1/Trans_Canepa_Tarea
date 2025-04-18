package com.example.trans.exception;

public class CuentaNotFoundException extends RuntimeException {

    public CuentaNotFoundException(String mensaje) {
        super(mensaje);
    }
}