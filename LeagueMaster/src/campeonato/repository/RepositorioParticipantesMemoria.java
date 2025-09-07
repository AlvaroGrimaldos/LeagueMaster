/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campeonato.repository;

import campeonato.interfaces.RepositorioParticipantes;
import campeonato.model.Equipo;
import campeonato.model.Arbitro;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación en memoria del repositorio de participantes
 * Aplica: Single Responsibility Principle
 */
public class RepositorioParticipantesMemoria implements RepositorioParticipantes {
    private final List<Equipo> equipos = new ArrayList<>();
    private final List<Arbitro> arbitros = new ArrayList<>();
    
    @Override
    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }
    
    @Override
    public void agregarArbitro(Arbitro arbitro) {
        arbitros.add(arbitro);
    }
    
    @Override
    public List<Equipo> obtenerEquipos() {
        return new ArrayList<>(equipos);
    }
    
    @Override
    public List<Arbitro> obtenerArbitros() {
        return new ArrayList<>(arbitros);
    }
}
