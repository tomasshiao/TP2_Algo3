public class Partida {

    private int cantidadJugadores;
    private final Jugador[] jugadores;

    public Partida(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
        jugadores = new Jugador[cantidadJugadores];
    }

    public void agregarJugador(Jugador unJugador) {
        int idJugador = unJugador.getId();
        jugadores[idJugador-1] = unJugador;
    }

    public int getCantidadJugadores(){
        return cantidadJugadores;
    }

}
