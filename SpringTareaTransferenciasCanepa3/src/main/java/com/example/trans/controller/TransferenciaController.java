package com.example.trans.controller;

import com.example.trans.dto.TransferenciaDTO;
import com.example.trans.exception.CuentaNotFoundException;
import com.example.trans.exception.SaldoInsuficienteException;
import com.example.trans.service.TransferenciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transferencias")
@Tag(name = "Transferencias", description = "API para realizar transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    @Operation(summary = "Realizar una transferencia entre cuentas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transferencia realizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Saldo insuficiente"),
            @ApiResponse(responseCode = "404", description = "Cuenta no encontrada")
    })
    public ResponseEntity<String> realizarTransferencia(@Valid @RequestBody TransferenciaDTO transferenciaDTO) {
        transferenciaService.realizarTransferencia(transferenciaDTO);
        return new ResponseEntity<>("Transferencia realizada con éxito", HttpStatus.OK);
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<String> handleSaldoInsuficienteException(SaldoInsuficienteException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CuentaNotFoundException.class)
    public ResponseEntity<String> handleCuentaNotFoundException(CuentaNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}