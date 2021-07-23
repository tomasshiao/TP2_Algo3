package algoteg;

import java.util.List;

public class RondaAtaque {
    private final Tablero tablero;
    private List<Jugador> jugadores;
    private int cantidadJugadores;
    private Jugador jugadorActual;

    /****************
     * Inicializa una ronda.
     * @param tablero Tablero
     * ***************/
    public RondaAtaque(Tablero tablero, Jugador jugadorActual) {
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

    public String atacar(Jugador atacante, Pais paisAtacante, Pais paisDefensor, int cantidadTropas) {
        try {
            tablero.atacar(atacante, paisAtacante, paisDefensor, cantidadTropas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return null;
    }

    public String moverEjercito(Pais paisOrigen, Pais paisDestino, int cantidadTropas){
        try {
            jugadorActual.moverEjercito(paisOrigen, paisDestino, cantidadTropas);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return null;
    }

}
