package algoteg.modelo;

//import java.util.List;

public class TurnoAtaque implements Turno{
    private Tablero tablero;
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

    public void iniciarTurno(Jugador jugador) {
        this.setJugador(jugador);
    }

    @Override
    public void activarTarjeta(Tarjeta tarjeta) {

    }

    @Override
    public boolean canjearTarjetas(Tarjeta tarjeta1, Tarjeta tarjeta2, Tarjeta tarjeta3) {
        return false;
    }

    public void setJugador(Jugador jugador){
        this.jugadorActual = jugadorActual;
    }

    public Tablero getTablero() {
        return this.tablero;
    }


    public Jugador getJugadorActual(){
        return this.jugadorActual;
    }

    @Override
    public Pais atacar(Pais paisAtacante, Pais paisDefensor, int cantidadTropas) {
        Pais pais = null;
        try {
            pais =  tablero.atacar(jugadorActual, paisAtacante, paisDefensor, cantidadTropas);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return  pais;
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
