package algoteg;

import java.util.*;

public class Ronda {
    private final Tablero tablero;
    private final List<Jugador> jugadores;
    private final int cantidadJugadores;

    /****************
     * Inicializa una ronda.
     * @param dtoPartida Map<String, Object>
     * ***************/
    public Ronda(Map<String, Object> dtoPartida) {
        this.tablero = (Tablero) dtoPartida.get("Tablero");
        this.jugadores = new ArrayList<>();
        if(dtoPartida.get("Jugadores") instanceof ArrayList<?>){
            ArrayList<?> arrayJugadores = ((ArrayList<?>) dtoPartida.get("Jugadores"));
            for(int i = 0; i < arrayJugadores.size(); i++){
                if(arrayJugadores.get(i) instanceof Jugador){
                    this.jugadores.add((Jugador) arrayJugadores.get(i));
                }
            }
        }
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
        //int posicionGanador = i - 1;
        boolean hayGanador = false;
        while (!hayGanador & i < this.getCantidadJugadores()) {
            Jugador jugadorActual = this.getJugadores().get(i);
            jugadorActual.realizarAtaques();
            hayGanador = jugadorActual.esGanador();
            i++;
        }

        while (!hayGanador & i < this.getCantidadJugadores()) {
            //acciones jugador
            Jugador jugadorActual = this.getJugadores().get(i);
            jugadorActual.realizarColocacionDeEjercitos();
            i++;
        }
        return hayGanador;
    }
}
