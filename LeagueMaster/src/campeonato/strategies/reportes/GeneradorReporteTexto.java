/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campeonato.strategies.reportes;

import campeonato.interfaces.GeneradorReporte;
import campeonato.model.Equipo;
import campeonato.model.Arbitro;
import java.util.List;

/**
 * Generador de reportes en formato texto
 * Aplica: Single Responsibility Principle
 */
public class GeneradorReporteTexto implements GeneradorReporte {
    @Override
    public String generarReporte(List<Equipo> equipos, List<Arbitro> arbitros) {
        StringBuilder contenido = new StringBuilder();
        contenido.append("--- Reporte del Campeonato (TEXTO) ---\n");
        contenido.append("EQUIPOS:\n");
        
        for (Equipo equipo : equipos) {
            contenido.append("- ").append(equipo.getNombre()).append("\n");
        }
        
        contenido.append("ÁRBITROS:\n");
        for (Arbitro arbitro : arbitros) {
            contenido.append("- ").append(arbitro.getNombre()).append("\n");
        }
        
        return contenido.toString();
    }
}
