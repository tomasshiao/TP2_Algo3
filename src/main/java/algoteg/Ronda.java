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
        /*int i = 0;
        boolean hayGanador = false;
        // Ronda de ataque
        while (!hayGanador & i < this.getCantidadJugadores()) {
            Jugador jugadorActual = this.getJugadores().get(i);
            jugadorActual.realizarAtaques();
            hayGanador = jugadorActual.esGanador();
            i++;
        }

        // Colocación de ejércitos
        i=0;
        while (!hayGanador & i < this.getCantidadJugadores()) {
            Jugador jugadorActual = this.getJugadores().get(i);
            jugadorActual.realizarColocacionDeEjercitos();
            i++;
        }*/

        boolean hayGanador = false;
        int i = 0;
        while (!hayGanador & i < this.getCantidadJugadores()) {
            Jugador jugadorActual = this.getJugadores().get(i);
            RondaAtaque rondaAtaque = new RondaAtaque(this.tablero, jugadorActual);
            hayGanador = jugadorActual.esGanador();
            i++;
        }

        i = 0;
        while (!hayGanador & i < this.getCantidadJugadores()){
            Jugador jugadorActual = this.getJugadores().get(i);
            RondaColocacion rondaColocacion = new RondaColocacion(this.tablero, jugadorActual);
            i++;
        }
        return hayGanador;
    }
}
