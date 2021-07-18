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

    @Test
    public void ganaDefensor(){

        Dado dadoAtacantemock = mock(Dado.class);
        when(dadoAtacantemock.getValor()).thenReturn(1);

        Dado dadoDefensormock = mock(Dado.class);
        when(dadoDefensormock.getValor()).thenReturn(6);

        List<Dado> dadosAtacante = new ArrayList<>();
        dadosAtacante.add(dadoAtacantemock);
        List<Dado> dadosDefensor = new ArrayList<>();
        dadosDefensor.add(dadoDefensormock);
        dadosDefensor.add(dadoDefensormock);

        Pais paisDefensor = mock(Pais.class);
        when(paisDefensor.getNombre()).thenReturn("Uruguay");
        when(paisDefensor.getEjercitoActual()).thenReturn(1);

        Pais paisAtacante = mock((Pais.class));
        when(paisAtacante.getNombre()).thenReturn("Argentina");
        when(paisAtacante.getEjercitoActual()).thenReturn(2);

        Batalla batallaMock = mock(Batalla.class);
        when(batallaMock.obtenerDadosDefensor(paisDefensor)).thenReturn(dadosDefensor);
        when(batallaMock.obtenerDadosAtacante(paisAtacante, 1)).thenReturn(dadosAtacante);

        Pais victorioso = batallaMock.obtenerVictoriosoDeGuerra(paisAtacante, paisDefensor, 1);

        assertEquals("Uruguay", victorioso.getNombre());
    }


}
