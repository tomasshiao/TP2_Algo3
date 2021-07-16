package algoteg;

import java.util.ArrayList;

public class Partida {

    private int cantidadTotalJugadores;
    private int cantidadJugadoresActuales;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<Tarjeta> tarjetas = new ArrayList<>();

    public Partida(int cantidadTotalJugadores) {
        cantidadJugadoresActuales = 0;
        if(cantidadTotalJugadores <= 6)
            this.cantidadTotalJugadores = cantidadTotalJugadores;
        else this.cantidadTotalJugadores = 6;
    }

    public void agregarJugador (Jugador unJugador) {
        int idJugador = unJugador.getId();
        if(jugadores.size() < this.cantidadTotalJugadores){
            jugadores.add(unJugador);
            this.cantidadJugadoresActuales++;
        }
    }

    public int getCantidadJugadoresActuales(){return cantidadJugadoresActuales;}
}
