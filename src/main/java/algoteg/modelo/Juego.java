package algoteg.modelo;

import algoteg.Exceptions.AtaqueInvalidoException;

import java.util.*;

public class Juego {
    Partida partida;
    List<String> colores = new ArrayList<>(List.of("#0077bb", "#cc3311", "#ee7733", "#009988","#ee3377","#000000"));



    public void iniciarJuegoConJugadores(Integer cantidadJugadores) {

        List<Jugador> jugadores = new ArrayList<>();
        Partida partida = new Partida(cantidadJugadores);
        this.partida = partida;
        Collections.shuffle(colores);


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
        return (partida.getCantidadJugadoresActuales());
    }

    public List<String> obtenerOrdenJugadores() {
        return partida.getOrdenJugadores();
    }

    public List<Objetivo> obtenerObjetivos() {
        return partida.getObjetivosDeJugadores();
    }

    public ArrayList<Jugador> getListaJugadores(){
        return this.partida.getListaJugadores();
    }
}
