package algoteg.modelo;

import java.util.*;

public class RondaColocacion {
    private final Tablero tablero;
    private List<Jugador> jugadores;
    private int cantidadJugadores;
    private Jugador jugadorActual;

    /****************
     * Inicializa una ronda.
     * @param tablero Tablero
     * ***************/
    public RondaColocacion(Tablero tablero, Jugador jugadorActual) {
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;
    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public List<Jugador> getJugadores() {
        return this.jugadores;
    }

    public int getCantidadJugadores() {
        return this.cantidadJugadores;
    }

    public void colocarEjercitos(int cantidadTropas, Pais pais, Jugador jugador){
        jugador.addEjercitoEnPais(pais, cantidadTropas);
    }

    public void setEjercitosDisponiblesParaColocar(Jugador jugador){
        int ejercitosDisponibles = jugador.getCantidadPaisesConquistados()/2;
        List<Continente> continentes = tablero.getContinentesGobernadosPor(jugador);

        for(Continente continente : continentes){
            ejercitosDisponibles += continente.getBonusTropas();
        }
        jugador.addEjercito(ejercitosDisponibles);
    }

    public void activarTarjeta(Tarjeta tarjeta) {
        this.jugadorActual.activarTarjeta(tarjeta);
    }
}
