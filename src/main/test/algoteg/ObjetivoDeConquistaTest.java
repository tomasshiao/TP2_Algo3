package algoteg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjetivoDeConquistaTest {
    Jugador jugador1 = new Jugador(1, "azul");
    Pais paisMock = mock(Pais.class);
    Pais paisMock2 = mock(Pais.class);
    Pais paisMock3 = mock(Pais.class);
    Pais paisMock4 = mock(Pais.class);
    Continente continenteMock = mock(Continente.class);
    Continente continenteMock2 = mock(Continente.class);
    List<Pais> paises = new ArrayList<>();
    List<Pais> paises2 = new ArrayList<>();
    Map<Continente, Integer> territorioAConquistar = new HashMap<>();

    @Test
    public void jugadorCumpleObjetivoDeConquistar3PaisesDeEuropa(){
        when(paisMock.getNombre()).thenReturn("Francia");
        when(paisMock2.getNombre()).thenReturn("Italia");
        when(paisMock3.getNombre()).thenReturn("Inglaterra");
        when(continenteMock.getPaises()).thenReturn(paises);

        paises.add(paisMock);
        paises.add(paisMock2);
        paises.add(paisMock3);
        territorioAConquistar.put(continenteMock, 3);
        jugador1.addPaisConquistado(paisMock);
        jugador1.addPaisConquistado(paisMock2);
        jugador1.addPaisConquistado(paisMock3);

        Objetivo objetivo = new ObjetivoDeConquista(territorioAConquistar);
        objetivo.setJugador(jugador1);

        assertTrue(objetivo.cumplido());
    }

    @Test
    public void jugadorNoCumpleObjetivoDeConquistar3PaisesDeEuropa(){
        when(paisMock.getNombre()).thenReturn("Francia");
        when(paisMock2.getNombre()).thenReturn("Italia");
        when(paisMock3.getNombre()).thenReturn("Inglaterra");
        when(continenteMock.getPaises()).thenReturn(paises);

        paises.add(paisMock);
        paises.add(paisMock2);
        paises.add(paisMock3);
        territorioAConquistar.put(continenteMock, 3);
        jugador1.addPaisConquistado(paisMock);
        jugador1.addPaisConquistado(paisMock2);

        Objetivo objetivo = new ObjetivoDeConquista(territorioAConquistar);
        objetivo.setJugador(jugador1);

        assertFalse(objetivo.cumplido());
    }

    @Test
    public void jugadorCumpleObjetivoDeConquistar2PaisesDeEuropaY1DeAsia(){
        when(paisMock.getNombre()).thenReturn("Francia");
        when(paisMock2.getNombre()).thenReturn("Italia");
        when(paisMock3.getNombre()).thenReturn("Japon");
        when(continenteMock.getPaises()).thenReturn(paises);
        when(continenteMock2.getPaises()).thenReturn(paises2);

        paises.add(paisMock);
        paises.add(paisMock2);
        paises2.add(paisMock3);
        territorioAConquistar.put(continenteMock, 2);
        territorioAConquistar.put(continenteMock2, 1);
        jugador1.addPaisConquistado(paisMock);
        jugador1.addPaisConquistado(paisMock2);
        jugador1.addPaisConquistado(paisMock3);

        Objetivo objetivo = new ObjetivoDeConquista(territorioAConquistar);
        objetivo.setJugador(jugador1);

        assertTrue(objetivo.cumplido());
    }

    @Test
    public void jugadorCumpleObjetivoDeConquistarPaises3Limitrofes(){
        List<Pais> limitrofes1 = new ArrayList<>();
        List<Pais> limitrofes2 = new ArrayList<>();
        List<Pais> limitrofes3 = new ArrayList<>();
        List<Pais> limitrofes4 = new ArrayList<>();

        when(paisMock.getNombre()).thenReturn("Argentina");
        when(paisMock2.getNombre()).thenReturn("Brasil");
        when(paisMock3.getNombre()).thenReturn("Chile");
        when(paisMock4.getNombre()).thenReturn("Uruguay");

        when(paisMock.getPaisesLimitrofes()).thenReturn(limitrofes1);
        when(paisMock2.getPaisesLimitrofes()).thenReturn(limitrofes2);
        when(paisMock3.getPaisesLimitrofes()).thenReturn(limitrofes3);
        when(paisMock4.getPaisesLimitrofes()).thenReturn(limitrofes4);

        jugador1.addPaisConquistado(paisMock);
        jugador1.addPaisConquistado(paisMock2);
        jugador1.addPaisConquistado(paisMock3);
        jugador1.addPaisConquistado(paisMock4);

        limitrofes1.add(paisMock2);
        limitrofes2.add(paisMock3);
        limitrofes3.add(paisMock4);

        Objetivo objetivo = new ObjetivoDeConquista(territorioAConquistar,3);
        objetivo.setJugador(jugador1);

        assertTrue(objetivo.cumplido());
    }

    @Test
    public void jugadorNoCumpleObjetivoDeConquistar3PaisesLimitrofes(){
        List<Pais> limitrofes1 = new ArrayList<>();
        List<Pais> limitrofes2 = new ArrayList<>();
        List<Pais> limitrofes3 = new ArrayList<>();

        when(paisMock.getNombre()).thenReturn("Argentina");
        when(paisMock2.getNombre()).thenReturn("Brasil");
        when(paisMock3.getNombre()).thenReturn("Chile");

        when(paisMock.getPaisesLimitrofes()).thenReturn(limitrofes1);
        when(paisMock2.getPaisesLimitrofes()).thenReturn(limitrofes2);
        when(paisMock3.getPaisesLimitrofes()).thenReturn(limitrofes3);

        jugador1.addPaisConquistado(paisMock);
        jugador1.addPaisConquistado(paisMock2);
        jugador1.addPaisConquistado(paisMock3);

        limitrofes1.add(paisMock2);
        limitrofes2.add(paisMock3);

        Objetivo objetivo = new ObjetivoDeConquista(territorioAConquistar,3);
        objetivo.setJugador(jugador1);

        assertFalse(objetivo.cumplido());
    }

    @Test
    public void jugadorCumpleObjetivoDeConquistar2PaisesLimitrofesY2PaisesDeEuropa(){
        List<Pais> limitrofes1 = new ArrayList<>();
        List<Pais> limitrofes2 = new ArrayList<>();

        when(paisMock.getNombre()).thenReturn("Argentina");
        when(paisMock2.getNombre()).thenReturn("Uruguay");
        when(paisMock3.getNombre()).thenReturn("Alemania");
        when(paisMock4.getNombre()).thenReturn("Belgica");

        when(paisMock.getPaisesLimitrofes()).thenReturn(limitrofes1);
        when(paisMock3.getPaisesLimitrofes()).thenReturn(limitrofes2);

        when(continenteMock.getPaises()).thenReturn(paises);

        paises.add(paisMock3);
        paises.add(paisMock4);
        territorioAConquistar.put(continenteMock, 2);

        jugador1.addPaisConquistado(paisMock);
        jugador1.addPaisConquistado(paisMock2);
        jugador1.addPaisConquistado(paisMock3);
        jugador1.addPaisConquistado(paisMock4);

        limitrofes1.add(paisMock2);
        limitrofes2.add(paisMock4);

        Objetivo objetivo = new ObjetivoDeConquista(territorioAConquistar,2);
        objetivo.setJugador(jugador1);

        assertTrue(objetivo.cumplido());
    }
}


