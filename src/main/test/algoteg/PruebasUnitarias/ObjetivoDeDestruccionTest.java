package algoteg.PruebasUnitarias;

import algoteg.modelo.Jugador;
import algoteg.modelo.Objetivo;
import algoteg.modelo.ObjetivoDeDestruccion;
import algoteg.modelo.Pais;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

public class ObjetivoDeDestruccionTest {
    Jugador jugador1 = new Jugador(1, "azul");
    Jugador jugador2 = new Jugador(2, "verde");
    Jugador jugador3 = new Jugador(3, "rojo");
    ArrayList<Jugador> listaJugadores = new ArrayList<>();
    Pais paisMock = mock(Pais.class);

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

}
