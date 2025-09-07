/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campeonato.interfaces;

import campeonato.model.Equipo;
import campeonato.model.Arbitro;
import java.util.List;

/**
 * Interface para generadores de reportes
 * Aplica: Open/Closed Principle y Dependency Inversion Principle
 */
public interface GeneradorReporte {
    String generarReporte(List<Equipo> equipos, List<Arbitro> arbitros);
}
