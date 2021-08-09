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
        this.jugadorActual.addEjercitoEnPais(pais, canTropas);
    }
    @Override
    public String atacar(Pais paisAtacante, Pais paisDefensor, int cantidadTropas){return null;}
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
        //int ejercitosDisponibles = this.jugadorActual.getCantidadPaisesConquistados()/2;
        List<Continente> continentes = tablero.getContinentesGobernadosPor(this.jugadorActual);

        this.jugadorActual.setEjercitoDisponibles(continentes);

    }

    public void activarTarjeta(Tarjeta tarjeta) {
        this.jugadorActual.activarTarjeta(tarjeta);
    }

    @Override
    public boolean terminado() {return this.jugadorActual.getEjercitoParaIncorporar() == 0;}
}
