package algoteg.modelo;

import java.util.*;

public interface Turno{

    void colocar(int cantTropas, Pais Pais);
    void setJugador(Jugador jugador);
    Pais atacar(Pais paisAtacante, Pais paisDefensor, int cantidadTropas);
    String moverEjercito(Pais paisOrigen, Pais paisDestino, int cantidadTropas);
    boolean terminado();
    void iniciarTurno(Jugador jugador);
    void activarTarjeta(Tarjeta tarjeta);
    boolean canjearTarjetas(Tarjeta tarjeta1, Tarjeta tarjeta2, Tarjeta tarjeta3);


}

