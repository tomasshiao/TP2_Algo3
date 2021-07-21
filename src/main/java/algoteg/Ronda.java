package algoteg;

import java.util.*;

public class Ronda {
    private final Tablero tablero;
    private final ArrayList<Jugador> jugadores;

    public Ronda(Tablero tablero, ArrayList<Jugador> jugadores) {
        this.tablero = tablero;
        this.jugadores = jugadores;
    }

    private Tablero getTablero() {
        return this.tablero;
    }
    private List<Jugador> getJugador() {
        return this.jugadores;
    }

    public boolean iniciarRonda() {
        return true;
    }
}
