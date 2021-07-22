package algoteg;

import java.util.*;

public class Ronda {
    private final Tablero tablero;
    private final ArrayList<Jugador> jugadores;
    private final int cantidadJugadores;

    /****************
     * Inicializa una ronda.
     * @param dtoPartida Map<String, Object>
     * ***************/
    public Ronda(Map<String, Object> dtoPartida) {
        this.tablero = (Tablero) dtoPartida.get("Tablero");
        this.jugadores = (ArrayList<Jugador>) dtoPartida.get("Jugadores");
        this.cantidadJugadores = this.jugadores.size();
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

    public boolean iniciarRonda() {
        int i = 0;
        int posicionGanador = i - 1;
        boolean hayGanador = false;
        while (!hayGanador & i < this.getCantidadJugadores()) {
            //acciones jugador
            Jugador jugadorActual = this.getJugadores().get(i);
            jugadorActual.realizarTurno();
            hayGanador = jugadorActual.esGanador();
            i++;
        }

        //return jugadores.get(posicionGanador);
        return hayGanador;
    }
}
