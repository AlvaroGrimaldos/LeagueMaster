/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campeonato.interfaces;

import campeonato.model.Jugador;

/**
 * Interface para estrategias de cálculo de bonificaciones
 * Aplica: Open/Closed Principle y Dependency Inversion Principle
 */
public interface CalcularBonificacion {
    String calcularBonificacion(Jugador jugador);
}
