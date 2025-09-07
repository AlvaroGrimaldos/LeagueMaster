# Aplicacion de principios SOLID a el proyecto LeagueMaster

### Autor: Alvaro Andres Grimaldos Sarmiento

## 1. Single Responsibility Principle (SRP)
### Antes: La clase GestorCampeonato tenia multiples responsabilidades
```java
public class GestorCampeonato {

private List<Equipo> equipos = new ArrayList<>();
private List<Arbitro> arbitros = new ArrayList<>();

/**
 * Registra los participantes en el sistema.
 */
public void registrarParticipantes() {
// Registrar equipos
}

/**
 * Calcula las bonificaciones para los jugadores.
 */
public void calcularBonificaciones() {
}

/**
 * Genera y muestra en consola diferentes tipos de reportes.
 */
public void generarReportes(String formato) {
}
```
### Despues: Se separaron esas responsabilidades en distintos archivos
```bash
ServicioRegistroParticipantes: Maneja el registro.
ServicioBonificaciones: Calcula bonificaciones.
ServicioReportes: Genera reportes.
RepositorioParticipantesMemoria: Maneja el almacenamiento.
```

## 2. Open/Closed Principle (OCP)
### Antes: Para agregar posiciones o formatos tocaba modificar los metodos
```java
public void calcularBonificaciones() {
        System.out.println("\n--- Calculando Bonificaciones de Jugadores ---");
        for (Equipo equipo : equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador.getPosicion().equals("Delantero")) {
                    System.out.println(
                    "Calculando bonificación alta para Delantero: " + jugador.getNombre());

                } else if (jugador.getPosicion().equals("Portero")) {
                    System.out.println("Calculando bonificación estándar para Portero: " + jugador.getNombre());

                } else {
                    System.out.println("Calculando bonificación base para: " + jugador.getNombre());
                }
            }
        }
}
```

### Despues: Se crearon interfaces extensibles
```bash
CalcularBonificacion: Permite agregar nuevas estrategias de bonificacion sin modificar codigo existente.
GeneradorReporte: Permite agregar nuevos formatos.
FactoryCalculadorBonificacion y FactoryGeneradorReporte: Maneja la creacion dinamicamente.
```

## 3. Liskov Subtitution Principle (LSP)
### Despues: Todas las implementaciones son completamente intercambiables
```java
CalculadorBonificacion calc1 = new CalculadorBonificacionDelantero();
CalculadorBonificacion calc2 = new CalculadorBonificacionPortero();
```

## 4. Interface Segregation Principle (ISP)
### Despues: Cree interfaces especificas y cohesivas
```bash
CalcularBonificacion: Solo un metodo calcularBonificacion().
GeneradorReporte: Solo un metodo generarReporte().
RepositorioParticipantes: Metodos especificos para manejo de datos.
```

## 5. Dependency Inversion Principle (DIP)
### Antes: Dependencias directas a implementaciones concretas
```java
public class GestorCampeonato {
    private List<Equipo> equipos = new ArrayList<>(); 
}
```

### Despues: Dependencias a abstracciones
```java
public class ServicioBonificaciones {
    private final RepositorioParticipantes repositorio; // Interfaz
    private final FactoryCalculadorBonificacion factory; // Abstracción
    
    // Constructor injection
    public ServicioBonificaciones(RepositorioParticipantes repositorio, 
                                 FactoryCalculadorBonificacion factory) {
        this.repositorio = repositorio;
        this.factory = factory;
    }
}
```