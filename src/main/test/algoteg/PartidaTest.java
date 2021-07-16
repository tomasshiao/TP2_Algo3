package algoteg;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PartidaTest {
    Partida unaPartida = new Partida(6);
    Jugador jugadorMock = mock(Jugador.class);
    Jugador jugador1 = new Jugador(1, "azul");
    Jugador jugador2 = new Jugador(2, "rojo");

    @Test
    public void seAgreganJugadoresALaPartida(){
        unaPartida.agregarJugador(jugadorMock);
        unaPartida.agregarJugador(jugadorMock);

        assertEquals(2,unaPartida.getCantidadJugadoresActuales());
    }

    @Test
    public void seQuierenAgregar7JugadoresPeroSoloSePermitenHasta6(){
        unaPartida.agregarJugador(jugadorMock);
        unaPartida.agregarJugador(jugadorMock);
        unaPartida.agregarJugador(jugadorMock);
        unaPartida.agregarJugador(jugadorMock);
        unaPartida.agregarJugador(jugadorMock);
        unaPartida.agregarJugador(jugadorMock);
        unaPartida.agregarJugador(jugadorMock);
        assertEquals(6,unaPartida.getCantidadJugadoresActuales());
    }

}