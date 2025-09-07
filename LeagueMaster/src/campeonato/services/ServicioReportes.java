/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campeonato.services;

import campeonato.interfaces.RepositorioParticipantes;
import campeonato.interfaces.GeneradorReporte;
import campeonato.factories.FactoryGeneradorReporte;

/**
 * Servicio especializado en la generación de reportes
 * Aplica: Single Responsibility Principle y Dependency Inversion Principle
 */
public class ServicioReportes {
    private final RepositorioParticipantes repositorio;
    private final FactoryGeneradorReporte factory;
    
    public ServicioReportes(RepositorioParticipantes repositorio, 
                           FactoryGeneradorReporte factory) {
        this.repositorio = repositorio;
        this.factory = factory;
    }
    
    public void generarReporte(String formato) {
        try {
            GeneradorReporte generador = factory.obtenerGenerador(formato);
            String reporte = generador.generarReporte(
                repositorio.obtenerEquipos(), 
                repositorio.obtenerArbitros()
            );
            System.out.println(reporte);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}