package algoteg.modelo;

import java.util.*;

public class TurnoColocacion implements Turno{
    private final Tablero tablero;
    private List<Jugador> jugadores;
    private int cantidadJugadores;
    private Jugador jugadorActual;

    /****************
     * Inicializa una ronda.
     * @param tablero Tablero
     * ***************/
    public TurnoColocacion(Tablero tablero) {
        this.tablero = tablero;
    }
    @Override
    public void setJugador(Jugador jugadorActual){
        this.jugadorActual = jugadorActual;
    }
    @Override
    public void colocar(int canTropas, Pais pais){
        System.out.println("colocar turno");
        this.jugadorActual.addEjercitoEnPais(pais, canTropas);
    }
    @Override
    public Pais atacar(Pais paisAtacante, Pais paisDefensor, int cantidadTropas){return null;}
    @Override
    public String moverEjercito(Pais paisOrigen, Pais paisDestino, int cantidadTropas){return null;}

    public Tablero getTablero() {
        return this.tablero;
    }

    public List<Jugador> getJugadores() {
        return this.jugadores;
    }

    public int getCantidadJugadores() {
        return this.cantidadJugadores;
    }

    public void colocarEjercitos(int cantidadTropas, Pais pais){

        this.jugadorActual.addEjercitoEnPais(pais, cantidadTropas);
    }

    public void setEjercitosDisponiblesParaColocar(){
        this.jugadorActual.setEjercitoDisponibles();

    }

    @Override
    public void iniciarTurno(Jugador jugador) {
        this.setJugador(jugador);
        this.setEjercitosDisponiblesParaColocar();
    }

    public void activarTarjeta(Tarjeta tarjeta) {
        this.jugadorActual.activarTarjeta(tarjeta);
    }

    public boolean canjearTarjetas(Tarjeta tarjeta1, Tarjeta tarjeta2, Tarjeta tarjeta3){
        return this.jugadorActual.canjearTarjetas(tarjeta1, tarjeta2, tarjeta3);
    }

    @Override
    public boolean terminado() {return this.jugadorActual.getEjercitoParaIncorporar() == 0;}


}
