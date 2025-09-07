/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campeonato.factories;

import campeonato.interfaces.GeneradorReporte;
import campeonato.strategies.reportes.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory para crear generadores de reportes
 * Aplica: Open/Closed Principle y Single Responsibility Principle
 */
public class FactoryGeneradorReporte {
    private final Map<String, GeneradorReporte> generadores;
    
    public FactoryGeneradorReporte() {
        generadores = new HashMap<>();
        generadores.put("TEXTO", new GeneradorReporteTexto());
        generadores.put("HTML", new GeneradorReporteHtml());
    }
    
    public GeneradorReporte obtenerGenerador(String formato) {
        GeneradorReporte generador = generadores.get(formato.toUpperCase());
        if (generador == null) {
            throw new IllegalArgumentException("Formato no soportado: " + formato);
        }
        return generador;
    }
}
