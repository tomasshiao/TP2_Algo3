package algoteg;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartidaTest {
    Partida unaPartida = new Partida(2);
    Jugador jugador1 = new Jugador(1, "azul");
    Jugador jugador2 = new Jugador(2, "rojo");

    @Test
    public void seAgreganJugadoresALaPartida(){
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador2);
        assertEquals(2,unaPartida.getCantidadJugadoresActuales());
    }

    @Test
    public void seQuierenAgregar7JugadoresPeroSoloSePermitenHasta6(){
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador1);
        unaPartida.agregarJugador(jugador1);
        assertEquals(6,unaPartida.getCantidadJugadoresActuales());
    }


}