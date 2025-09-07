/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campeonato.services;

import campeonato.interfaces.RepositorioParticipantes;
import campeonato.model.*;

/**
 * Servicio especializado en el registro de participantes
 * Aplica: Single Responsibility Principle
 */
public class ServicioRegistroParticipantes {
    private final RepositorioParticipantes repositorio;
    
    public ServicioRegistroParticipantes(RepositorioParticipantes repositorio) {
        this.repositorio = repositorio;
    }
    
    public void registrarParticipantes() {
        // Registrar equipos
        Equipo equipoA = new Equipo("Los Ganadores");
        equipoA.agregarJugador(new Jugador("Juan Pérez", "Delantero"));
        equipoA.agregarJugador(new Jugador("Pedro Pan", "Portero"));
        repositorio.agregarEquipo(equipoA);
        System.out.println("Equipo 'Los Ganadores' registrado.");
        
        Equipo equipoB = new Equipo("Los Retadores");
        equipoB.agregarJugador(new Jugador("Alicia Smith", "Defensa"));
        repositorio.agregarEquipo(equipoB);
        System.out.println("Equipo 'Los Retadores' registrado.");
        
        // Contratar árbitros
        repositorio.agregarArbitro(new Arbitro("Miguel Díaz"));
        System.out.println("Árbitro 'Miguel Díaz' contratado.");
    }
}
