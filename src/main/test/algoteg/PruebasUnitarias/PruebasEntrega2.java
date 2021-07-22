package algoteg.PruebasUnitarias;

import algoteg.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PruebasEntrega2 {


    public boolean iniciarRondaMockTest01(Jugador j1, Jugador j2, Pais p1, Pais p2) {
        j1.addEjercitoEnPais(p1, 6);
        j2.addEjercitoEnPais(p2, 8);
        return true; //para que no de error el mock
    }

    @Test
    public void test01RondaDeDosJugadoresQueColocanEjercitos() {
        Jugador j1 = new Jugador(1, "rojo");
        j1.setEjercitoParaIncorporar(10);

        Jugador j2 = new Jugador(2, "azul");
        j2.setEjercitoParaIncorporar(10);


        Pais p1 = new Pais("Argentina", j1);
        j1.addPaisConquistado(p1);

        Pais p2 = new Pais("Chile", j2);
        j2.addPaisConquistado(p2);

        Ronda rondaMock = mock(Ronda.class);
        when(rondaMock.iniciarRonda()).thenReturn(this.iniciarRondaMockTest01(j1, j2, p1, p2));
        rondaMock.iniciarRonda();

        assertEquals(j1.getCantidadPaisesConquistados(), 1);
        assertEquals(j2.getCantidadPaisesConquistados(), 1);
        //solo se agregaron ejercitos, no se ataco en ningun momento

        assertEquals(j1.getEjercitoParaIncorporar(), 4);
        assertEquals(j2.getEjercitoParaIncorporar(), 2);




    }


    private boolean iniciarRondaMockTest02(Jugador j1, Jugador j2, Jugador j3 ,Pais p1, Pais p2, Pais p3) {
        j1.addEjercitoEnPais(p1, 6);
        j2.addEjercitoEnPais(p2, 8);
        j3.addEjercitoEnPais(p3, 10);
        return true; //para que no de error el mock
    }

    @Test
    public void test02RondaDeTresJugadoresQueColocanEjercitos() {
        Jugador j1 = new Jugador(1, "rojo");
        j1.setEjercitoParaIncorporar(10);

        Jugador j2 = new Jugador(2, "azul");
        j2.setEjercitoParaIncorporar(10);

        Jugador j3 = new Jugador(3, "negro");
        j3.setEjercitoParaIncorporar(10);

        Pais p1 = new Pais("Argentina", j1);
        j1.addPaisConquistado(p1);

        Pais p2 = new Pais("Chile", j2);
        j2.addPaisConquistado(p2);

        Pais p3 = null;

        List<String> paisesDeAsia = new ArrayList<>(Arrays.asList("Arabia", "Aral", "China", "Gobi", "India", "Iran", "Israel", "Japon", "Kamchatka", "Malasia", "Mongolia", "Siberia", "Taimir", "Tartaria", "Turquia"));
        for(String nombrePais: paisesDeAsia) {
            Pais pais = new Pais(nombrePais, j3);
            j3.addPaisConquistado(pais);
            p3 = pais;
        }


        Ronda rondaMock = mock(Ronda.class);
        when(rondaMock.iniciarRonda()).thenReturn(this.iniciarRondaMockTest02(j1, j2, j3 ,p1, p2, p3));
        rondaMock.iniciarRonda();

        assertEquals(j1.getCantidadPaisesConquistados(), 1);
        assertEquals(j2.getCantidadPaisesConquistados(), 1);
        assertEquals(j3.getCantidadPaisesConquistados(), 15);
        //solo se agregaron ejercitos, no se ataco en ningun momento

        assertEquals(j1.getEjercitoParaIncorporar(), 4);
        assertEquals(j2.getEjercitoParaIncorporar(), 2);
        assertEquals(j3.getEjercitoParaIncorporar(), 0);



    }




    /********
    * Una ronda de dos jugadores: se produce un ataque y el atacante conquista dos países.
    * ********/

    public boolean iniciarRondaMockTest03(Jugador j1, Pais paisAtacante ,Pais paisASerConquistadoPrimero, Pais paisASerConquistadoDespues, Tablero tablero) {
        try {
            tablero.atacar(j1, paisAtacante, paisASerConquistadoPrimero, 1);
            tablero.atacar(j1, paisAtacante, paisASerConquistadoDespues, 1);
        } catch(Exception e){
            System.out.println(e.getMessage());
            // Opción pasar por parámetro Map<String, String> outMap.
            // outMap.put("ExceptionErrorMessage: ", e.getMessage());
            return false;
        }
        return true;
    }

    public Pais atacarTableroMockTest03(Jugador j1, Pais paisAtacante, Pais paisDefensor, int numeroTropas) {
        Dado dadoAtacanteMock = mock(Dado.class);
        when(dadoAtacanteMock.getValor()).thenReturn(6);

        Dado dadoDefensorMock = mock(Dado.class);
        when(dadoDefensorMock.getValor()).thenReturn(1);

        List<GeneradorRandom> dadosAtacante = Collections.singletonList(dadoAtacanteMock);
        List<GeneradorRandom> dadosDefensor = Collections.singletonList(dadoDefensorMock);

        Batalla batalla = new Batalla();
        return batalla.obtenerVictoriosoDeGuerra(dadosAtacante, dadosDefensor, paisAtacante, paisDefensor, numeroTropas);
    }

    @Test
    public void test03RondaDeDosJugadoresUnoAtacaYConquistaDosPaisesDelOtro() {
        Jugador atacante = new Jugador(1, "Azul");
        Jugador defensor = new Jugador(2, "Naranja");
        Pais paisAtacante = new Pais("PaisAtacante", atacante);
        paisAtacante.agregarEjercito(50);

        atacante.addPaisConquistado(paisAtacante);

        Pais paisASerConquistadoPrimero = new Pais("MeConquistanPrimero", defensor);
        paisASerConquistadoPrimero.agregarEjercito(1);

        Pais paisASerConquistadoDespues = new Pais("MeConquistanDespues", defensor);
        paisASerConquistadoDespues.agregarEjercito(1);

        defensor.addPaisConquistado(paisASerConquistadoPrimero);
        defensor.addPaisConquistado(paisASerConquistadoDespues);

        List<Pais> listaPaises = new ArrayList<>();
        listaPaises.add(paisAtacante);
        listaPaises.add(paisASerConquistadoPrimero);
        listaPaises.add(paisASerConquistadoDespues);

        //Map<String, String> outMap = new HashMap<>();

        Tablero tableroMock = mock(Tablero.class);
        try {
            when(tableroMock.atacar(atacante, paisAtacante, paisASerConquistadoPrimero, 1)).thenReturn(this.atacarTableroMockTest03(atacante, paisAtacante, paisASerConquistadoPrimero, 1));
            when(tableroMock.atacar(atacante, paisAtacante, paisASerConquistadoDespues, 1)).thenReturn(this.atacarTableroMockTest03(atacante, paisAtacante, paisASerConquistadoDespues, 1));
        } catch (Exception e){
            return;
        }

        Ronda rondaMock = mock(Ronda.class);
        when(rondaMock.iniciarRonda()).thenReturn(this.iniciarRondaMockTest03(atacante, paisAtacante ,paisASerConquistadoPrimero, paisASerConquistadoDespues, tableroMock));
        rondaMock.iniciarRonda();

        assertTrue(atacante.getPaisesConquistados().contains(paisASerConquistadoPrimero));
        assertTrue(atacante.getPaisesConquistados().contains(paisASerConquistadoDespues));


    }

}
