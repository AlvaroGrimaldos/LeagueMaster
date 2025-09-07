/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campeonato.strategies.bonificaciones;

import campeonato.interfaces.CalcularBonificacion;
import campeonato.model.Jugador;

/**
 * Estrategia específica para bonificaciones de delanteros
 * Aplica: Single Responsibility Principle
 */
public class CalculadorBonificacionDelantero implements CalcularBonificacion {
    @Override
    public String calcularBonificacion(Jugador jugador) {
        return "Calculando bonificación alta para Delantero: " + jugador.getNombre();
    }
}
