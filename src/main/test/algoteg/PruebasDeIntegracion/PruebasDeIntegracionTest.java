package algoteg.PruebasDeIntegracion;

import algoteg.*;
import algoteg.datosJuego.InitializePaisesYContinentes;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PruebasDeIntegracionTest {



    @Test
    public void rondaDeDosJugadoresQueColocanEjercitos() {
        Jugador j1 = new Jugador(1, "rojo");
        Jugador j2 = new Jugador(2, "azul");
        Partida p = new Partida(2);
        p.agregarJugador(j1);
        p.agregarJugador(j2);

        InitializePaisesYContinentes initPyC = new InitializePaisesYContinentes();
        List<Pais> paises = initPyC.getTodosLosPaises();
        List<Continente> continentes = initPyC.getTodosLosContinentes();

        Partida partida = mock(Partida.class);

    }


    @Test
    public void rondaDeTresJugadoresQueColocanEjercitos() {

    }



    @Test
    public void rondaDeDosJugadoresUnoAtacaYConquistaDosPaisesDelOtro() {

    }

}
