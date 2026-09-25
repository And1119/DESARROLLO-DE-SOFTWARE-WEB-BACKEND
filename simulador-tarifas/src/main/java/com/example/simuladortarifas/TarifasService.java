package com.example.simuladortarifas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TarifasService {

    @Value("${tarifa.base:50000.0}")
    private double tarifaBase;

    public double calcularLiquidacion(int creditos, double descuento) {
        double valorCreditos = creditos * tarifaBase;
        double subtotal = valorCreditos;
        double valorDescuento = subtotal * (descuento / 100);
        return subtotal - valorDescuento;
    }
}