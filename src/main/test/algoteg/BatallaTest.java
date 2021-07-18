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

public class BatallaTest {
    Batalla batalla = new Batalla();



    @Test
    public void dadosAtacantesOrdenadosDescendiente(){
        Pais paisAtacanteMock = mock(Pais.class);
        when(paisAtacanteMock.getEjercitoActual()).thenReturn(4);

        List<Dado> dados = batalla.obtenerDadosAtacante(paisAtacanteMock, 4);

        assertTrue(dados.get(0).getValor() >= (dados.get(1).getValor()));
        assertTrue(dados.get(1).getValor() >= dados.get(2).getValor());
    }

    @Test
    public void pierdeAtacante(){
        Dado dadoAtacantemock = mock(Dado.class);
        when(dadoAtacantemock.getValor()).thenReturn(1);

        Dado dadoDefensormock = mock(Dado.class);
        when(dadoDefensormock.getValor()).thenReturn(6);

        Pais paisAtacantemock = mock(Pais.class);
        when(paisAtacantemock.getNombre()).thenReturn("Argentina");
        Pais paisDenfesormock = mock(Pais.class);
        when(paisDenfesormock.getNombre()).thenReturn("Uruguay");

        Pais perdedor = batalla.obtenerPerdedorDeBatalla(dadoAtacantemock,dadoDefensormock, paisAtacantemock,paisDenfesormock);
        assertEquals("Argentina", perdedor.getNombre());
    }

    @Test
    public void pierdeDefensor(){
        Dado dadoAtacantemock = mock(Dado.class);
        when(dadoAtacantemock.getValor()).thenReturn(8);

        Dado dadoDefensormock = mock(Dado.class);
        when(dadoDefensormock.getValor()).thenReturn(0);

        Pais paisAtacantemock = mock(Pais.class);
        when(paisAtacantemock.getNombre()).thenReturn("Argentina");
        Pais paisDenfesormock = mock(Pais.class);
        when(paisDenfesormock.getNombre()).thenReturn("Uruguay");

        Pais perdedor = batalla.obtenerPerdedorDeBatalla(dadoAtacantemock,dadoDefensormock, paisAtacantemock,paisDenfesormock);
        assertEquals("Uruguay", perdedor.getNombre());

    }
    @Test
    public void ganaDefensorPorqueAtacanteNoTieneTropasParaAtacar(){

        Pais paisAtacanteMock = mock(Pais.class);
        when(paisAtacanteMock.getNombre()).thenReturn("Argentina");
        when(paisAtacanteMock.getEjercitoActual()).thenReturn(0);
        Pais paisDefensorMock = mock(Pais.class);
        when(paisDefensorMock.getNombre()).thenReturn("Uruguay");
        when(paisDefensorMock.getEjercitoActual()).thenReturn(1);


        Pais ganador = batalla.obtenerVictoriosoDeGuerra(paisAtacanteMock,paisDefensorMock, 1);

        assertEquals("Uruguay", ganador.getNombre());
    }
}
