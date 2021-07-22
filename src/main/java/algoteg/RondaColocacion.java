package algoteg;

package algoteg;

import java.util.*;

public class RondaColocacion {
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

    public void colocarEjercito(){

    }
    private int obtenerEjercitosDisponibles(Jugador jugador){
        jugador.getCantidadPaisesConquistados();
        List<Continente> continentes = tablero.obtenerContinentesGobernadoPor(jugador);
    }
}

