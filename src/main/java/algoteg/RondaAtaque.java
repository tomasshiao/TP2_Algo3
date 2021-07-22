package algoteg;

import java.util.List;

public class RondaAtaque {
    private final Tablero tablero;
    private List<Jugador> jugadores;
    private int cantidadJugadores;

    /****************
     * Inicializa una ronda.
     * @param tablero Tablero
     * ***************/
    public RondaAtaque(Tablero tablero) {
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

    public String atacar(Jugador atacante, Pais paisAtacante, Pais paisDefensor, int cantidadTropas) {
        try {
            tablero.atacar(atacante, paisAtacante, paisDefensor, cantidadTropas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return null;
    }

}
