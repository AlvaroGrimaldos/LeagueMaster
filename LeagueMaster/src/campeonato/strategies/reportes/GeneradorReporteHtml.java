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
 * Generador de reportes en formato HTML
 * Aplica: Single Responsibility Principle
 */
public class GeneradorReporteHtml implements GeneradorReporte {
    @Override
    public String generarReporte(List<Equipo> equipos, List<Arbitro> arbitros) {
        StringBuilder contenido = new StringBuilder();
        contenido.append("<html><body>\n");
        contenido.append(" <h1>Reporte del Campeonato</h1>\n");
        contenido.append(" <h2>Equipos</h2>\n <ul>\n");
        
        for (Equipo equipo : equipos) {
            contenido.append(" <li>").append(equipo.getNombre()).append("</li>\n");
        }
        
        contenido.append(" </ul>\n <h2>Árbitros</h2>\n <ul>\n");
        for (Arbitro arbitro : arbitros) {
            contenido.append(" <li>").append(arbitro.getNombre()).append("</li>\n");
        }
        
        contenido.append(" </ul>\n</body></html>");
        return contenido.toString();
    }
}