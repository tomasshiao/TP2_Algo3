package algoteg.modelo;

//import java.util.List;

public class TurnoAtaque implements Turno{
    private final Tablero tablero;
    //private List<Jugador> jugadores;
    //private int cantidadJugadores;
    private Jugador jugadorActual;
    private boolean terminado;

    /****************
     * Inicializa una ronda.
     * @param tablero Tablero
     * ***************/
    public TurnoAtaque(Tablero tablero) {
        this.tablero = tablero;
        this.terminado = false;

    }

    public void setJugador(Jugador jugador){
        this.jugadorActual = jugadorActual;
    }

    public Tablero getTablero() {
        return this.tablero;
    }

    /*public List<Jugador> getJugadores() {
        return this.jugadores;
    }

    public int getCantidadJugadores() {
        return this.cantidadJugadores;
    }*/

    public Jugador getJugadorActual(){
        return this.jugadorActual;
    }

    public String atacar(Pais paisAtacante, Pais paisDefensor, int cantidadTropas) {
        try {
            tablero.atacar(jugadorActual, paisAtacante, paisDefensor, cantidadTropas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return null;
    }

    public String moverEjercito(Pais paisOrigen, Pais paisDestino, int cantidadTropas){
        try {
            tablero.moverEjercito(paisOrigen, paisDestino, cantidadTropas, this.jugadorActual);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return null;
    }
    @Override
    public void colocar(int cantTropas, Pais pais){};

    public void setTerminado() { this.terminado = true;}

     @Override
    public boolean terminado() { return this.terminado;}


}
