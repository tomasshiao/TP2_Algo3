package algoteg.PruebasUnitarias;

import algoteg.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.*;

public class RondaTest {
    private static Tablero tableroMock = mock(Tablero.class);
    private static Jugador j1Mock = mock(Jugador.class);
    private static Jugador j2Mock = mock(Jugador.class);
    private static ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(j1Mock, j2Mock));
    private static int cantidadJugadores = 2;


    /**********
     * Verifica si el constructor y getters funcionan de la manera esperada.
     **********/
    @Test
    public void constructorLosGettersFuncionanCorrectamente(){
        Map<String, Object> dtoPartida = new HashMap<>();
        dtoPartida.put("Tablero", tableroMock);
        dtoPartida.put("Jugadores", jugadores);
        Ronda ronda = new Ronda(dtoPartida);
        assertEquals(cantidadJugadores, ronda.getCantidadJugadores());
        assertEquals(tableroMock, ronda.getTablero());
        assertEquals(j1Mock, ronda.getJugadores().get(0));
        assertEquals(j2Mock, ronda.getJugadores().get(1));
    }


    /************************
     * Verifica si iniciar ronda devuelve correctamente si hay o no un ganador.
     * Caso Negativo: No hay ganador en esta ronda.
     * Caso Positivo 1: el último jugador de la ronda gana.
     * Caso Positivo 2: algún jugador distinto al último gana.
     ************************/
    @Test
    public void iniciarRondaQueNoTieneGanadorASuTerminoDevuelveFalse(){
        Map<String, Object> dtoPartida = new HashMap<>();
        dtoPartida.put("Tablero", tableroMock);
        dtoPartida.put("Jugadores", jugadores);
        Ronda ronda = new Ronda(dtoPartida);
        when(j1Mock.esGanador()).thenReturn(false);
        when(j2Mock.esGanador()).thenReturn(false);
        assertFalse(ronda.iniciarRonda());
    }

    @Test
    public void iniciarRondaQueTieneGanadorASuTerminoDevuelveTrue1(){
        Map<String, Object> dtoPartida = new HashMap<>();
        dtoPartida.put("Tablero", tableroMock);
        dtoPartida.put("Jugadores", jugadores);
        Ronda ronda = new Ronda(dtoPartida);
        when(j1Mock.esGanador()).thenReturn(false);
        when(j2Mock.esGanador()).thenReturn(true);
        assertTrue(ronda.iniciarRonda());
    }

    @Test
    public void iniciarRondaQueTieneGanadorASuTerminoDevuelveTrue2(){
        Map<String, Object> dtoPartida = new HashMap<>();
        dtoPartida.put("Tablero", tableroMock);
        dtoPartida.put("Jugadores", jugadores);
        Ronda ronda = new Ronda(dtoPartida);
        when(j1Mock.esGanador()).thenReturn(true);
        assertTrue(ronda.iniciarRonda());
    }

}
