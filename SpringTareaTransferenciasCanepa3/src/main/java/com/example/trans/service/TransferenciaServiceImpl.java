package com.example.trans.service;

import com.example.trans.dto.TransferenciaDTO;
import com.example.trans.exception.CuentaNotFoundException;
import com.example.trans.exception.SaldoInsuficienteException;
import com.example.trans.model.Cuenta;
import com.example.trans.repository.CuentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    private final CuentaRepository cuentaRepository;

    @Autowired
    public TransferenciaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    @Transactional
    public void realizarTransferencia(TransferenciaDTO transferenciaDTO) {
        // Obtener cuenta origen
        Cuenta cuentaOrigen = cuentaRepository.findById(transferenciaDTO.getCuentaOrigenId())
                .orElseThrow(() -> new CuentaNotFoundException("Cuenta origen no encontrada"));

        // Obtener cuenta destino
        Cuenta cuentaDestino = cuentaRepository.findById(transferenciaDTO.getCuentaDestinoId())
                .orElseThrow(() -> new CuentaNotFoundException("Cuenta destino no encontrada"));

        // Verificar saldo suficiente
        if (cuentaOrigen.getSaldo() < transferenciaDTO.getMonto()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar la transferencia");
        }

        // Realizar la transferencia
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - transferenciaDTO.getMonto());
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + transferenciaDTO.getMonto());

        // Guardar cambios
        cuentaRepository.save(cuentaOrigen);
        cuentaRepository.save(cuentaDestino);
    }
}