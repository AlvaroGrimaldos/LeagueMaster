/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campeonato.services;

import campeonato.interfaces.RepositorioParticipantes;
import campeonato.interfaces.CalcularBonificacion;
import campeonato.factories.FactoryCalculadorBonificacion;
import campeonato.model.*;

/**
 * Servicio especializado en el cálculo de bonificaciones
 * Aplica: Single Responsibility Principle y Dependency Inversion Principle
 */
public class ServicioBonificaciones {
    private final RepositorioParticipantes repositorio;
    private final FactoryCalculadorBonificacion factory;
    
    public ServicioBonificaciones(RepositorioParticipantes repositorio, 
                                 FactoryCalculadorBonificacion factory) {
        this.repositorio = repositorio;
        this.factory = factory;
    }
    
    public void calcularBonificaciones() {
        System.out.println("\n--- Calculando Bonificaciones de Jugadores ---");
        
        for (Equipo equipo : repositorio.obtenerEquipos()) {
            for (Jugador jugador : equipo.getJugadores()) {
                CalcularBonificacion calculador = factory.obtenerCalculador(jugador.getPosicion());
                String resultado = calculador.calcularBonificacion(jugador);
                System.out.println(resultado);
            }
        }
    }
}
