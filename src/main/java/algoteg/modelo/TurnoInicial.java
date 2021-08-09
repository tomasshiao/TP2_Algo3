package algoteg.modelo;

import java.util.*;

public class TurnoInicial implements Turno{
    private final Tablero tablero;

    private int cantidadJugadores;
    private Jugador jugadorActual;
    int tropasDisponiblesPrimeraColocacion = 5;
    int tropasDisponiblesSegundaColocacion = 3;

    /****************
     * Inicializa una ronda.
     * @param tablero Tablero
     * ***************/
    public TurnoInicial(Tablero tablero, int cantidadAIncorporar) {
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;
    }

    public Tablero getTablero() {
        return this.tablero;
    }


    @Override

    public void colocarEjercito(Pais pais, int cantTropas) {
        if (cantTropas <= tropasDisponiblesPrimeraColocacion) {
            this.tropasDisponiblesPrimeraColocacion -= cantTropas;
            pais.agregarEjercito(cantTropas);
        } else if (cantTropas <= tropasDisponiblesSegundaColocacion) {
            this.tropasDisponiblesSegundaColocacion -= cantTropas;
            pais.agregarEjercito(cantTropas);
        }
    }
}