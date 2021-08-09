package algoteg.PruebasUnitarias;

import algoteg.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TurnoColocacionTest {

    private static Tablero tableroMock = mock(Tablero.class);
    private static Jugador j1Mock = mock(Jugador.class);
    private static Jugador j2Mock = mock(Jugador.class);
    private static ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(j1Mock, j2Mock));
    private static int cantidadJugadores = 2;

//    @Test
//    public void jugadorTiene3PaisesConSusTarjetasYLosActivaEnLaRondaDeColocacionRecibiendo6Tropas(){
//        Jugador jugador1 = new Jugador(1, "azul");
//
//        Pais pais1 = mock(Pais.class);
//        Pais pais2 = mock(Pais.class);
//        Pais pais3 = mock(Pais.class);
//
//        Tarjeta tarjeta1 = new Tarjeta(pais1, "globo");
//        Tarjeta tarjeta2 = new Tarjeta(pais2, "globo");
//        Tarjeta tarjeta3 = new Tarjeta(pais3, "globo");
//
//        jugador1.addPaisConquistado(pais1);
//        jugador1.addPaisConquistado(pais2);
//        jugador1.addPaisConquistado(pais3);
//        jugador1.addTarjeta(tarjeta1);
//        jugador1.addTarjeta(tarjeta2);
//        jugador1.addTarjeta(tarjeta3);
//
//        TurnoColocacion turnoColocacion = new TurnoColocacion(tableroMock, jugador1);
//        turnoColocacion.activarTarjeta(tarjeta1);
//        turnoColocacion.activarTarjeta(tarjeta2);
//        turnoColocacion.activarTarjeta(tarjeta3);
//
//        assertEquals(6,jugador1.getEjercitoParaIncorporar());
//    }

//    @Test
//    public void jugadorTiene2PaisesDeSus3TarjetasYLosActivaEnLaRondaDeColocacionRecibiendo4Tropas(){
//        Jugador jugador1 = new Jugador(1, "azul");
//
//        Pais pais1 = mock(Pais.class);
//        Pais pais2 = mock(Pais.class);
//        Pais pais3 = mock(Pais.class);
//
//        Tarjeta tarjeta1 = new Tarjeta(pais1, "globo");
//        Tarjeta tarjeta2 = new Tarjeta(pais2, "globo");
//        Tarjeta tarjeta3 = new Tarjeta(pais3, "globo");
//
//        jugador1.addPaisConquistado(pais1);
//        jugador1.addPaisConquistado(pais2);
//        jugador1.addTarjeta(tarjeta1);
//        jugador1.addTarjeta(tarjeta2);
//        jugador1.addTarjeta(tarjeta3);
//
//        TurnoColocacion turnoColocacion = new TurnoColocacion(tableroMock, jugador1);
//        turnoColocacion.activarTarjeta(tarjeta1);
//        turnoColocacion.activarTarjeta(tarjeta2);
//        turnoColocacion.activarTarjeta(tarjeta3);
//
//        assertEquals(4,jugador1.getEjercitoParaIncorporar());
//    }

//    @Test
//    public void jugadorTiene3PaisesPeroSolo1TarjetaDeEstosYLaActivaEnLaRondaDeColocacionRecibiendo2Tropas(){
//        Jugador jugador1 = new Jugador(1, "azul");
//        Tarjeta tarjetaMock = mock(Tarjeta.class);
//
//        Pais pais1 = mock(Pais.class);
//        Pais pais2 = mock(Pais.class);
//        Pais pais3 = mock(Pais.class);
//
//        Tarjeta tarjeta1 = new Tarjeta(pais1, "globo");
//        Tarjeta tarjeta2 = new Tarjeta(pais2, "globo");
//        Tarjeta tarjeta3 = new Tarjeta(pais3, "globo");
//
//        jugador1.addPaisConquistado(pais1);
//        jugador1.addPaisConquistado(pais2);
//        jugador1.addPaisConquistado(pais3);
//        jugador1.addTarjeta(tarjeta1);
//        jugador1.addTarjeta(tarjetaMock);
//        jugador1.addTarjeta(tarjetaMock);
//
//        TurnoColocacion turnoColocacion = new TurnoColocacion(tableroMock, jugador1);
//        turnoColocacion.activarTarjeta(tarjeta1);
//        turnoColocacion.activarTarjeta(tarjeta2);
//        turnoColocacion.activarTarjeta(tarjeta3);
//
//        assertEquals(2,jugador1.getEjercitoParaIncorporar());
//    }

}

