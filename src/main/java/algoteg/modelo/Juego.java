package algoteg.modelo;

import algoteg.Exceptions.AtaqueInvalidoException;

import java.util.*;

public class Juego {
    Partida partida;
    List<String> colores = List.of("azul", "rojo", "rosa", "naranja","verde","negro");
    Integer cantJugadores= 0;



    public void iniciarJuegoConJugadores(Integer cantidadJugadores) {

        List<Jugador> jugadores = new ArrayList<>();
        Partida partida = new Partida(cantidadJugadores);
        this.cantJugadores = cantidadJugadores;

        //primero inicializo jugadores

        for (int i = 0; i < cantidadJugadores; i++) {
            partida.agregarJugador(new Jugador(i, colores.get(i)));
        }
        partida.iniciarPartida();

    }


    public void atacar(Pais paisAtacante, Pais paisDefensor, int cantidadTropas) throws AtaqueInvalidoException {
        partida.atacar(paisAtacante, paisDefensor, cantidadTropas);
    }

    public void mover(Pais paisOrigen, Pais paisLlegada, int cantidadTropas){
        partida.mover(paisOrigen, paisLlegada, cantidadTropas);
    }

    public int getCantidadJugadores(){
        return (this.cantJugadores);
    }

}
