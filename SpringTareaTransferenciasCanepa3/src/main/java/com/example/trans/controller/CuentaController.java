package com.example.trans.controller;

import com.example.trans.model.Cuenta;
import com.example.trans.repository.CuentaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
@Tag(name = "Cuentas", description = "API para gestionar cuentas bancarias")
public class CuentaController {

    private final CuentaRepository cuentaRepository;

    @Autowired
    public CuentaController(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @PostMapping
    @Operation(summary = "Crear una nueva cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cuenta creada exitosamente")
    })
    public ResponseEntity<Cuenta> crearCuenta(@Valid @RequestBody Cuenta cuenta) {
        // Asegurarse de que el ID sea null para crear una nueva cuenta
        cuenta.setId(null);

        Cuenta nuevaCuenta = cuentaRepository.save(cuenta);
        return new ResponseEntity<>(nuevaCuenta, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Obtener todas las cuentas")
    public ResponseEntity<List<Cuenta>> obtenerTodasLasCuentas() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        return new ResponseEntity<>(cuentas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una cuenta por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cuenta encontrada"),
            @ApiResponse(responseCode = "404", description = "Cuenta no encontrada")
    })
    public ResponseEntity<Cuenta> obtenerCuentaPorId(@PathVariable Long id) {
        return cuentaRepository.findById(id)
                .map(cuenta -> new ResponseEntity<>(cuenta, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}