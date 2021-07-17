package algoteg;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class DadoTest {
    Batalla batalla = new Batalla();
    Pais paisMock = mock(Pais.class);
    Jugador jugadorMock = mock(Jugador.class);
    Dado dado = new Dado();
    List<Dado> listaDados = new ArrayList<>();

    @Test
    public void dadoSeisEsMayorQue5(){
        Dado dado0 = mock(Dado.class);
        when(dado0.getValor()).thenReturn(0);
        Dado dado = new Dado();

        assertTrue(dado.esMayorQue(dado0));
    }

    @Test
    public void atancanteTiene4TropasYTira3Dados(){
        when((paisMock.getEjercitoActual())).thenReturn(4);
        listaDados = batalla.obtenerDadosAtacante(paisMock, 3);
        assertEquals(3, batalla.getDadosParaTirarAtacante());
    }

    @Test
    public void atacanteTieneSoloUnaTropaYNoPuedeTirarDadosParaAtacar(){
        when((paisMock.getEjercitoActual())).thenReturn(1);
        listaDados = batalla.obtenerDadosAtacante(paisMock, 1);

        assertEquals(0, batalla.getDadosParaTirarAtacante());
    }

    @Test
    public void atacanteTiene2TropasEIntentaTirar3DadosPeroSoloLeDejaTirarUno(){
        when((paisMock.getEjercitoActual())).thenReturn(2);
        listaDados = batalla.obtenerDadosAtacante(paisMock, 3);

        assertEquals(1, batalla.getDadosParaTirarAtacante());
    }

    @Test
    public void atacanteIntentaAtacarConMasDadosDeLoPermitidoPeroSoloLeDejaTirarTres(){
        when((paisMock.getEjercitoActual())).thenReturn(15);
        listaDados = batalla.obtenerDadosAtacante(paisMock, 8);

        assertEquals(3, batalla.getDadosParaTirarAtacante());
    }

    @Test
    public void defensorTiene3TropasYTira3Dados(){
        when((paisMock.getEjercitoActual())).thenReturn(3);
        listaDados = batalla.obtenerDadosDefensor(paisMock);

        assertEquals(3, batalla.getDadosParaTirarDefensor());
    }

    @Test
    public void defensorTieneMuchasTropasPeroSoloPuedeDefenderseConTresDados(){
        when((paisMock.getEjercitoActual())).thenReturn(10);
        listaDados = batalla.obtenerDadosDefensor(paisMock);

        assertEquals(3, batalla.getDadosParaTirarDefensor());
    }

    @Test
    public void defensorTieneUnaSolaTropaYPuedeUsarlaParaDefenderse(){
        when((paisMock.getEjercitoActual())).thenReturn(1);
        listaDados = batalla.obtenerDadosDefensor(paisMock);

        assertEquals(1, batalla.getDadosParaTirarDefensor());
    }

}
