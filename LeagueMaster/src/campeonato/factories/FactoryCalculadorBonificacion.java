/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campeonato.factories;

import campeonato.interfaces.CalcularBonificacion;
import campeonato.strategies.bonificaciones.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory para crear calculadores de bonificación
 * Aplica: Open/Closed Principle y Single Responsibility Principle
 */
public class FactoryCalculadorBonificacion {
    private final Map<String, CalcularBonificacion> calculadores;
    
    public FactoryCalculadorBonificacion() {
        calculadores = new HashMap<>();
        calculadores.put("Delantero", new CalculadorBonificacionDelantero());
        calculadores.put("Portero", new CalculadorBonificacionPortero());
    }
    
    public CalcularBonificacion obtenerCalculador(String posicion) {
        return calculadores.getOrDefault(posicion, new CalculadorBonificacionBase());
    }
}
