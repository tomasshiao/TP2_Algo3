package algoteg;

public class Partida {

    private int cantidadTotalJugadores;
    private int cantidadJugadoresActuales;
    private Jugador[] jugadores;

    public Partida(int cantidadTotalJugadores) {
        cantidadJugadoresActuales = 0;
        if(cantidadTotalJugadores <= 6)
            this.cantidadTotalJugadores = cantidadTotalJugadores;
        else this.cantidadTotalJugadores = 6;
        jugadores = new Jugador[cantidadTotalJugadores];
    }

    public void agregarJugador (Jugador unJugador) {
        int idJugador = unJugador.getId();
        if(this.cantidadJugadoresActuales<6){
            jugadores[idJugador-1] = unJugador;
            this.cantidadJugadoresActuales++;
        }

    }

    public int getCantidadJugadoresActuales(){return cantidadJugadoresActuales;}

}