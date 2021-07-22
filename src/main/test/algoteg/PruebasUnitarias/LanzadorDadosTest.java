package algoteg.PruebasUnitarias;

import algoteg.GeneradorRandom;
import algoteg.LanzadorDados;
import algoteg.Pais;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LanzadorDadosTest {
    LanzadorDados lanzadorDados = new LanzadorDados();
    Pais paisMock = mock(Pais.class);
    List<GeneradorRandom> listaDados;
    @Test
    public void dadosAtacantesOrdenadosDescendiente(){
        Pais paisAtacanteMock = mock(Pais.class);
        when(paisAtacanteMock.getEjercitoActual()).thenReturn(4);
        LanzadorDados lanzadorDados = new LanzadorDados();


        List<GeneradorRandom> dados = lanzadorDados.obtenerDadosAtacante(paisAtacanteMock, 4);

        assertTrue(dados.get(0).getValor() >= (dados.get(1).getValor()));
        assertTrue(dados.get(1).getValor() >= dados.get(2).getValor());
    }

    @Test
    public void atancanteTiene4TropasYTira3Dados(){
        when((paisMock.getEjercitoActual())).thenReturn(4);
        LanzadorDados lanzadorDados = new LanzadorDados();
        listaDados = lanzadorDados.obtenerDadosAtacante(paisMock, 3);
        assertEquals(3, lanzadorDados.getDadosParaTirarAtacante());
    }

    @Test
    public void atacanteTieneSoloUnaTropaYNoPuedeTirarDadosParaAtacar(){
        when((paisMock.getEjercitoActual())).thenReturn(1);
        LanzadorDados lanzadorDados = new LanzadorDados();
        listaDados = lanzadorDados.obtenerDadosAtacante(paisMock, 1);

        assertEquals(0, lanzadorDados.getDadosParaTirarAtacante());
    }

    @Test
    public void atacanteTiene2TropasEIntentaTirar3DadosPeroSoloLeDejaTirarUno(){
        when((paisMock.getEjercitoActual())).thenReturn(2);
        LanzadorDados lanzadorDados = new LanzadorDados();
        listaDados = lanzadorDados.obtenerDadosAtacante(paisMock, 3);

        assertEquals(1, lanzadorDados.getDadosParaTirarAtacante());
    }

    @Test
    public void atacanteIntentaAtacarConMasDadosDeLoPermitidoPeroSoloLeDejaTirarTres(){
        when((paisMock.getEjercitoActual())).thenReturn(15);
        LanzadorDados lanzadorDados = new LanzadorDados();
        listaDados = lanzadorDados.obtenerDadosAtacante(paisMock, 8);

        assertEquals(3, lanzadorDados.getDadosParaTirarAtacante());
    }

    @Test
    public void defensorTiene3TropasYTira3Dados(){
        when((paisMock.getEjercitoActual())).thenReturn(3);
        LanzadorDados lanzadorDados = new LanzadorDados();
        listaDados = lanzadorDados.obtenerDadosDefensor(paisMock);

        assertEquals(3, lanzadorDados.getDadosParaTirarDefensor());
    }

    @Test
    public void defensorTieneMuchasTropasPeroSoloPuedeDefenderseConTresDados(){
        when((paisMock.getEjercitoActual())).thenReturn(10);
        LanzadorDados lanzadorDados = new LanzadorDados();
        listaDados = lanzadorDados.obtenerDadosDefensor(paisMock);

        assertEquals(3, lanzadorDados.getDadosParaTirarDefensor());
    }

    @Test
    public void defensorTieneUnaSolaTropaYPuedeUsarlaParaDefenderse(){
        when((paisMock.getEjercitoActual())).thenReturn(1);
        LanzadorDados lanzadorDados = new LanzadorDados();
        listaDados = lanzadorDados.obtenerDadosDefensor(paisMock);

        assertEquals(1, lanzadorDados.getDadosParaTirarDefensor());
    }
}
