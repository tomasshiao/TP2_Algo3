package algoteg;

import java.util.*;

public class RondaColocacion {
    private final Tablero tablero;
    private List<Jugador> jugadores;
    private int cantidadJugadores;

    /****************
     * Inicializa una ronda.
     * @param tablero Tablero
     * ***************/
    public RondaColocacion(Tablero tablero) {
        this.tablero = tablero;
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
        jugador.setEjercitoParaIncorporar(ejercitosDisponibles);
    }

    private void activarTarjeta(Tarjeta tarjeta, Jugador jugador) {
        jugador.addTarjeta(tarjeta);
    }
}
