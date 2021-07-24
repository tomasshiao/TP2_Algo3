package algoteg.PruebasUnitarias;

import algoteg.modelo.Jugador;
import algoteg.modelo.Partida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PartidaTest {
    Partida unaPartida = new Partida(6);
    Jugador jugadorMock = mock(Jugador.class);

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