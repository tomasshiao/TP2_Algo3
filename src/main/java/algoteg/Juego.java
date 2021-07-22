package algoteg;

import java.util.ArrayList;
import java.util.List;
import algoteg.Exceptions.*;

public class Juego {
    Partida partida;
    List<String> colores = List.of("azul", "rojo", "rosa", "naranja","verde","negro");


    public void juego() {
        int cantidadTotalDeJugadores = 6;
        Partida partida = new Partida(cantidadTotalDeJugadores);

        //primero inicializo jugadores

        for(int i = 0; i<cantidadTotalDeJugadores; i++){
            partida.agregarJugador(new Jugador(i, colores.get(i)));
        }


    }


}
