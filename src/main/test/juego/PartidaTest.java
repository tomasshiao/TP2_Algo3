package juego;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartidaTest {
    Partida unaPartida = new Partida(2);
    Jugador jugador1 = new Jugador(1, "azul");
    Jugador jugador2 = new Jugador(2, "rojo");
    Pais unPais = new Pais("Argentina");

    @Test
    public void Partida(){
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador2);
        unPais.agregarEjercito(2);
        unPais.reducirEjercito(1);
        assertEquals(1, unPais.getEjercitoActual());
    }
}