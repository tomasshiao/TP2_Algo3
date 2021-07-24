package algoteg.modelo;

import java.util.*;

public class Juego {
    Partida partida;
    List<String> colores = List.of("azul", "rojo", "rosa", "naranja","verde","negro");


    public void juego(Integer cantidadJugadores) {

        List<Jugador> jugadores = new ArrayList<>();
        Partida partida = new Partida(cantidadJugadores);

        //primero inicializo jugadores
        Collections.shuffle(colores);
        for(int i = 0; i<cantidadJugadores; i++){
            jugadores.add(new Jugador(i, colores.get(i)));
        }

    }



}
