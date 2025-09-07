/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campeonato.interfaces;

import campeonato.model.Equipo;
import campeonato.model.Arbitro;
import java.util.List;

/**
 * Interface para repositorio de participantes
 * Aplica: Single Responsibility Principle y Dependency Inversion Principle
 */
public interface RepositorioParticipantes {
    void agregarEquipo(Equipo equipo);
    void agregarArbitro(Arbitro arbitro);
    List<Equipo> obtenerEquipos();
    List<Arbitro> obtenerArbitros();
}
