package algoteg.modelo;

import java.util.*;

public class TurnoInicial implements Turno{
    private final Tablero tablero;

    private int cantidadJugadores;
    private Jugador jugadorActual;
    //int tropasDisponiblesPrimeraColocacion = 5;
    //int tropasDisponiblesSegundaColocacion = 3;
    private int cantidadAIncorporar;

    /****************
     * Inicializa una ronda.
     * @param tablero Tablero
     * ***************/
    public TurnoInicial(Tablero tablero, int cantidadAIncorporar) {
        this.tablero = tablero;

    }
    @Override
    public void setJugador(Jugador jugadorActual){
        this.jugadorActual = jugadorActual;
    }
    public Tablero getTablero() {
        return this.tablero;
    }


    @Override

    public void colocar( int cantTropas, Pais pais) {

        if (cantTropas <= cantidadAIncorporar && this.jugadorActual.tienePais(pais)) {
            this.cantidadAIncorporar -= cantTropas;
            pais.agregarEjercito(cantTropas);
        }
    }

    @Override
    public boolean terminado(){return (cantidadAIncorporar ==(0));}
    @Override
    public String atacar(Pais paisAtacante, Pais paisDefensor, int cantidadTropas){return null;}
    @Override
    public String moverEjercito(Pais paisOrigen, Pais paisDestino, int cantidadTropas){return null;}

}