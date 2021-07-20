package algoteg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjetivoDeDestruccionTest {
    Jugador jugador1 = new Jugador(1, "azul");
    Jugador jugador2 = new Jugador(2, "verde");
    Jugador jugador3 = new Jugador(3, "rojo");
    ArrayList<Jugador> listaJugadores = new ArrayList<>();
    Pais paisMock = mock(Pais.class);
    Pais paisMock2 = mock(Pais.class);
    Partida partida = new Partida(3);
    Continente continenteMock = mock(Continente.class);
    Continente continenteMock2 = mock(Continente.class);
    List<Pais> paises = new ArrayList<>();



    @Test
    public void jugadorAzulTieneQueDestruirARojoYCumpleSuObjetivo(){
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        Objetivo objetivo = new ObjetivoDeDestruccion("rojo" ,listaJugadores);
        objetivo.setJugador(jugador1);

        assertTrue(objetivo.cumplido());
    }

    @Test
    public void jugadorAzulTieneQueDestruirANegroPeroComoNoExisteTieneQueDestruirAVerde(){
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ObjetivoDeDestruccion objetivo = new ObjetivoDeDestruccion("negro" ,listaJugadores);
        objetivo.setJugador(jugador1);
        objetivo.cumplido();

        assertEquals("verde", objetivo.getColorADestruir());
    }

    @Test
    public void jugadorAzulTieneQueDestruirAVerdePeroNoLograObjetivo(){
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        Objetivo objetivo = new ObjetivoDeDestruccion("verde" ,listaJugadores);
        objetivo.setJugador(jugador1);
        jugador2.addPaisConquistado(paisMock);

        assertFalse(objetivo.cumplido());
    }

    @Test
    public void jugadorRojoEsUltimoDeLaListaYTieneQueDestruirColorInexistenteAsiQueSeLeAsignaAzul(){
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ObjetivoDeDestruccion objetivo = new ObjetivoDeDestruccion("negro" ,listaJugadores);
        objetivo.setJugador(jugador3);
        objetivo.cumplido();

        assertEquals("azul", objetivo.getColorADestruir());
    }
/*
    @Test
    public void verObjetivos(){
        for(Objetivo o: partida.getObjetivos())
            System.out.println(o.getMensajeObjetivo());
    }
*/

}
