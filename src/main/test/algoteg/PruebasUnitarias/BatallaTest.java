package algoteg.PruebasUnitarias;
import algoteg.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BatallaTest {
    Batalla batalla = new Batalla();





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
        LanzadorDados lanzadorDados = new LanzadorDados();
        List<GeneradorRandom> dadosAtacante = lanzadorDados.obtenerDadosAtacante(paisAtacanteMock, 1);
        List<GeneradorRandom> dadosDefensor = lanzadorDados.obtenerDadosDefensor(paisDefensorMock);

        Pais ganador = batalla.obtenerVictoriosoDeGuerra(dadosAtacante, dadosDefensor, paisAtacanteMock,paisDefensorMock, 1);

        assertEquals("Uruguay", ganador.getNombre());
    }

    @Test
    public void defensorGanaGuerraDeUnDado(){
        Pais paisAtacanteMock = mock(Pais.class);
        when(paisAtacanteMock.getNombre()).thenReturn("Argentina");
        when(paisAtacanteMock.getEjercitoActual()).thenReturn(2);
        Pais paisDefensorMock = mock(Pais.class);
        when(paisDefensorMock.getNombre()).thenReturn("Uruguay");
        when(paisDefensorMock.getEjercitoActual()).thenReturn(1);

        List<GeneradorRandom> dadosAtacante = new ArrayList<>();
        dadosAtacante.add(new DadoCero());
        List<GeneradorRandom> dadosDefensor = new ArrayList<>();
        dadosDefensor.add(new DadoSeis());
        dadosDefensor.add(new DadoSeis());

        Pais ganador = batalla.obtenerVictoriosoDeGuerra(dadosAtacante,dadosDefensor,paisAtacanteMock,paisDefensorMock, 1);

        assertEquals("Uruguay", ganador.getNombre());

    }

    @Test
    public void defensorGanaDosBatallasDeTresYGanaGuerra() {
        Pais paisAtacanteMock = mock(Pais.class);
        when(paisAtacanteMock.getNombre()).thenReturn("Argentina");
        when(paisAtacanteMock.getEjercitoActual()).thenReturn(4);
        Pais paisDefensorMock = mock(Pais.class);
        when(paisDefensorMock.getNombre()).thenReturn("Uruguay");
        when(paisDefensorMock.getEjercitoActual()).thenReturn(2);

        List<GeneradorRandom> dadosAtacante = new ArrayList<>();
        dadosAtacante.add(new DadoCero());
        dadosAtacante.add(new DadoSeis());
        dadosAtacante.add(new DadoCero());
        List<GeneradorRandom> dadosDefensor = new ArrayList<>();
        dadosDefensor.add(new DadoSeis());
        dadosDefensor.add(new DadoCero());
        dadosDefensor.add(new DadoSeis());

        Pais ganador = batalla.obtenerVictoriosoDeGuerra(dadosAtacante, dadosDefensor, paisAtacanteMock, paisDefensorMock, 1);

        assertEquals("Uruguay", ganador.getNombre());
    }

    @Test
    public void defensorGanaGuerraConUnEmpateYDosVictorias(){
        Pais paisAtacanteMock = mock(Pais.class);
        when(paisAtacanteMock.getNombre()).thenReturn("Argentina");
        when(paisAtacanteMock.getEjercitoActual()).thenReturn(4);
        Pais paisDefensorMock = mock(Pais.class);
        when(paisDefensorMock.getNombre()).thenReturn("Uruguay");
        when(paisDefensorMock.getEjercitoActual()).thenReturn(2);

        List<GeneradorRandom> dadosAtacante = new ArrayList<>();
        dadosAtacante.add(new DadoCero());
        dadosAtacante.add(new DadoSeis());
        dadosAtacante.add(new DadoCero());
        List<GeneradorRandom> dadosDefensor = new ArrayList<>();
        dadosDefensor.add(new DadoSeis());
        dadosDefensor.add(new DadoSeis());
        dadosDefensor.add(new DadoSeis());

        Pais ganador = batalla.obtenerVictoriosoDeGuerra(dadosAtacante, dadosDefensor, paisAtacanteMock, paisDefensorMock, 1);

        assertEquals("Uruguay", ganador.getNombre());

    }

    @Test
    public void atacanteGanaGuerraConUnDado(){
        Pais paisAtacanteMock = mock(Pais.class);
        when(paisAtacanteMock.getNombre()).thenReturn("Argentina");
        when(paisAtacanteMock.getEjercitoActual()).thenReturn(2);
        Pais paisDefensorMock = mock(Pais.class);
        when(paisDefensorMock.getNombre()).thenReturn("Uruguay");
        when(paisDefensorMock.getEjercitoActual()).thenReturn(1);

        List<GeneradorRandom> dadosAtacante = new ArrayList<>();
        dadosAtacante.add(new DadoSeis());
        List<GeneradorRandom> dadosDefensor = new ArrayList<>();
        dadosDefensor.add(new DadoCero());
        dadosDefensor.add(new DadoCero());

        Pais ganador = batalla.obtenerVictoriosoDeGuerra(dadosAtacante,dadosDefensor,paisAtacanteMock,paisDefensorMock, 1);

        assertEquals("Argentina", ganador.getNombre());

    }

    @Test
    public void atacanteGanaGuerraConDosVictoriasYUnaDerrota(){
        Pais paisAtacanteMock = mock(Pais.class);
        when(paisAtacanteMock.getNombre()).thenReturn("Argentina");
        when(paisAtacanteMock.getEjercitoActual()).thenReturn(4);
        Pais paisDefensorMock = mock(Pais.class);
        when(paisDefensorMock.getNombre()).thenReturn("Uruguay");
        when(paisDefensorMock.getEjercitoActual()).thenReturn(2);

        List<GeneradorRandom> dadosAtacante = new ArrayList<>();
        dadosAtacante.add(new DadoCero());
        dadosAtacante.add(new DadoSeis());
        dadosAtacante.add(new DadoSeis());
        List<GeneradorRandom> dadosDefensor = new ArrayList<>();
        dadosDefensor.add(new DadoSeis());
        dadosDefensor.add(new DadoCero());
        dadosDefensor.add(new DadoCero());

        Pais ganador = batalla.obtenerVictoriosoDeGuerra(dadosAtacante, dadosDefensor, paisAtacanteMock, paisDefensorMock, 1);

        assertEquals("Argentina", ganador.getNombre());
    }
    @Test
    public void atacanteGanaGuerraConDosVictoriasYUnEmpate(){
        Pais paisAtacanteMock = mock(Pais.class);
        when(paisAtacanteMock.getNombre()).thenReturn("Argentina");
        when(paisAtacanteMock.getEjercitoActual()).thenReturn(4);
        Pais paisDefensorMock = mock(Pais.class);
        when(paisDefensorMock.getNombre()).thenReturn("Uruguay");
        when(paisDefensorMock.getEjercitoActual()).thenReturn(2);

        List<GeneradorRandom> dadosAtacante = new ArrayList<>();
        dadosAtacante.add(new DadoSeis());
        dadosAtacante.add(new DadoSeis());
        dadosAtacante.add(new DadoSeis());
        List<GeneradorRandom> dadosDefensor = new ArrayList<>();
        dadosDefensor.add(new DadoCero());
        dadosDefensor.add(new DadoSeis());
        dadosDefensor.add(new DadoCero());

        Pais ganador = batalla.obtenerVictoriosoDeGuerra(dadosAtacante, dadosDefensor, paisAtacanteMock, paisDefensorMock, 1);

        assertEquals("Argentina", ganador.getNombre());
    }






}
