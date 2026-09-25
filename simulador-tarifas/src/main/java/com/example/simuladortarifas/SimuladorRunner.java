package com.example.simuladortarifas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimuladorRunner implements CommandLineRunner {

    @Autowired
    private TarifasService tarifasService;

    @Override
    public void run(String... args) throws Exception {
        int creditos = 16;
        double descuento = 10.0; // 10%

        double total = tarifasService.calcularLiquidacion(creditos, descuento);

        System.out.println("=== SIMULADOR DE LIQUIDACIÓN INSTITUCIONAL ===");
        System.out.println("Créditos inscritos: " + creditos);
        System.out.println("Descuento aplicado: " + descuento + "%");
        System.out.println("Total a pagar: $" + total);
        System.out.println("==============================================");
    }
}