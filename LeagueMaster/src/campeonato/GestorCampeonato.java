/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campeonato;

import campeonato.interfaces.RepositorioParticipantes;
import campeonato.repository.RepositorioParticipantesMemoria;
import campeonato.factories.*;
import campeonato.services.*;

/**
 * Orquestador principal que coordina los diferentes servicios
 * Aplica: Dependency Inversion Principle y Single Responsibility Principle
 */
public class GestorCampeonato {
    private final ServicioRegistroParticipantes servicioRegistro;
    private final ServicioBonificaciones servicioBonificaciones;
    private final ServicioReportes servicioReportes;
    
    public GestorCampeonato(ServicioRegistroParticipantes servicioRegistro,
                           ServicioBonificaciones servicioBonificaciones,
                           ServicioReportes servicioReportes) {
        this.servicioRegistro = servicioRegistro;
        this.servicioBonificaciones = servicioBonificaciones;
        this.servicioReportes = servicioReportes;
    }
    
    public void ejecutarGestionCompleta() {
        servicioRegistro.registrarParticipantes();
        servicioBonificaciones.calcularBonificaciones();
        
        System.out.println("\n--- Generando Reportes ---");
        servicioReportes.generarReporte("TEXTO");
        
        System.out.println("\n--- Generando más Reportes ---");
        servicioReportes.generarReporte("HTML");
    }
    
    // Factory method para crear el gestor con todas las dependencias
    public static GestorCampeonato crear() {
        RepositorioParticipantes repositorio = new RepositorioParticipantesMemoria();
        FactoryCalculadorBonificacion factoryBonificacion = new FactoryCalculadorBonificacion();
        FactoryGeneradorReporte factoryReporte = new FactoryGeneradorReporte();
        
        ServicioRegistroParticipantes servicioRegistro = 
            new ServicioRegistroParticipantes(repositorio);
        ServicioBonificaciones servicioBonificaciones = 
            new ServicioBonificaciones(repositorio, factoryBonificacion);
        ServicioReportes servicioReportes = 
            new ServicioReportes(repositorio, factoryReporte);
        
        return new GestorCampeonato(servicioRegistro, servicioBonificaciones, servicioReportes);
    }

    public static void main(String[] args) {
        GestorCampeonato gestor = GestorCampeonato.crear();
        gestor.ejecutarGestionCompleta();
    }
}
