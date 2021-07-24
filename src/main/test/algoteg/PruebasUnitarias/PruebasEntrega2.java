package algoteg.PruebasUnitarias;

import algoteg.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PruebasEntrega2 {
    private LanzadorDados lanzadorDados = new LanzadorDados();

    @Test
    public void test01RondaDeDosJugadoresQueColocanEjercitos() {
        Jugador j1 = new Jugador(1, "rojo");

        Jugador j2 = new Jugador(2, "azul");
        Pais p1 = new Pais("Argentina", j1);
        j1.addPaisConquistado(p1);

        Pais p2 = new Pais("Chile", j2);
        j2.addPaisConquistado(p2);

        Pais p3 = new Pais("Kamchatka", j2);
        j2.addPaisConquistado(p3);

        Pais p4 = new Pais("Japon", j1);
        j1.addPaisConquistado(p4);

        Continente continente = new Continente("prueba", 8);

        List<Pais> paises = List.of(p1,p2,p3,p4);
        continente.setPaises(paises);
        Tablero tablero = new Tablero(Collections.singletonList(continente), paises, lanzadorDados);



        RondaColocacion rondaColocacion = new RondaColocacion(tablero, null);

        rondaColocacion.setEjercitosDisponiblesParaColocar(j1);
        rondaColocacion.setEjercitosDisponiblesParaColocar(j2);

        rondaColocacion.colocarEjercitos(1,p1,j1);
        rondaColocacion.colocarEjercitos(1,p2,j2);

        assertEquals(2, j1.getCantidadPaisesConquistados());
        assertEquals(2, j2.getCantidadPaisesConquistados());
        //solo se agregaron ejercitos, no se ataco en ningun momento

        assertEquals(0, j1.getEjercitoParaIncorporar());
        assertEquals(0, j2.getEjercitoParaIncorporar());






    }


    @Test
    public void test02RondaDeTresJugadoresQueColocanEjercitos() {
        Jugador j1 = new Jugador(1, "rojo");

        Jugador j2 = new Jugador(2, "azul");

        Jugador j3 = new Jugador(3, "negro");

        Pais p1 = new Pais("Argentina", j1);
        j1.addPaisConquistado(p1);

        Pais p2 = new Pais("Peru", j1);
        j1.addPaisConquistado(p2);

        Pais p3 = new Pais("Chile", j2);
        j2.addPaisConquistado(p3);

        Pais p4 = new Pais("Uruguay", j2);
        j2.addPaisConquistado(p4);


        List<Pais> paisesAsia = new ArrayList<>();
        List<Pais> todosLosPaises = new ArrayList<>();
        todosLosPaises.add(p1);
        todosLosPaises.add(p2);
        todosLosPaises.add(p3);
        todosLosPaises.add(p4);
        List<String> paisesDeAsia = new ArrayList<>(Arrays.asList("Arabia", "Aral", "China", "Gobi", "India", "Iran", "Israel", "Japon", "Kamchatka", "Malasia", "Mongolia", "Siberia", "Taimir", "Tartaria", "Turquia"));
        for(String nombrePais: paisesDeAsia) {
            Pais pais = new Pais(nombrePais, j3);
            j3.addPaisConquistado(pais);
            paisesAsia.add(pais);
            todosLosPaises.add(pais);
        }

        Pais p5 = paisesAsia.get(0);

        List<Pais> paisesDeAmerica = Arrays.asList(p1, p2, p3, p4);

        Continente asia = new Continente("Asia", 8);
        asia.setPaises(paisesAsia);

        Continente america = new Continente("AmericaDelSur", 3);
        america.setPaises(paisesDeAmerica);

        List<Continente> continentes = Arrays.asList(asia, america);

        Tablero tablero = new Tablero(continentes, todosLosPaises, lanzadorDados);

        RondaColocacion rondaColocacion = new RondaColocacion(tablero, null);

        rondaColocacion.setEjercitosDisponiblesParaColocar(j1);
        rondaColocacion.setEjercitosDisponiblesParaColocar(j2);
        rondaColocacion.setEjercitosDisponiblesParaColocar(j3);

        rondaColocacion.colocarEjercitos(1,p1,j1);
        rondaColocacion.colocarEjercitos(1,p3,j2);
        rondaColocacion.colocarEjercitos(1,p5,j3);



        assertEquals(2, j1.getCantidadPaisesConquistados());
        assertEquals(2, j2.getCantidadPaisesConquistados());
        assertEquals(15, j3.getCantidadPaisesConquistados());
        //solo se agregaron ejercitos, no se ataco en ningun momento

        assertEquals(0, j1.getEjercitoParaIncorporar());
        assertEquals(0, j2.getEjercitoParaIncorporar());
        assertEquals(14, j3.getEjercitoParaIncorporar());
    }




    /********
    * Una ronda de dos jugadores: se produce un ataque y el atacante conquista dos países.
    * ********/


    public Pais atacarTableroMockTest03(Jugador j1, Pais paisAtacante, Pais paisDefensor, int numeroTropas) {
        GeneradorRandom dadoAtacanteMock = new DadoStub(6);

        GeneradorRandom dadoDefensorMock = new DadoStub(1);

        List<GeneradorRandom> dadosAtacante = Collections.singletonList(dadoAtacanteMock);
        List<GeneradorRandom> dadosDefensor = Collections.singletonList(dadoDefensorMock);

        Batalla batalla = new Batalla();
        return batalla.obtenerVictoriosoDeGuerra(dadosAtacante, dadosDefensor, paisAtacante, paisDefensor, numeroTropas);
    }

    @Test
    public void test03RondaDeDosJugadoresUnoAtacaYConquistaDosPaisesDelOtro() {
        Jugador atacante = new Jugador(1, "rojo");
        Jugador defensor = new Jugador(2, "azul");

        Pais paisAtacante = new Pais("PaisAtacante", atacante);
        paisAtacante.agregarEjercito(50);

        atacante.addPaisConquistado(paisAtacante);

        Pais paisASerConquistadoPrimero = new Pais("MeConquistanPrimero", defensor);
        paisASerConquistadoPrimero.agregarEjercito(1);

        Pais paisASerConquistadoDespues = new Pais("MeConquistanDespues", defensor);
        paisASerConquistadoDespues.agregarEjercito(1);

        defensor.addPaisConquistado(paisASerConquistadoPrimero);
        defensor.addPaisConquistado(paisASerConquistadoDespues);

        Tablero tableroMock = mock(Tablero.class);
        try {
            when(tableroMock.atacar(atacante, paisAtacante, paisASerConquistadoPrimero, 1)).thenReturn(this.atacarTableroMockTest03(atacante, paisAtacante, paisASerConquistadoPrimero, 1));
            when(tableroMock.atacar(atacante, paisAtacante, paisASerConquistadoDespues, 1)).thenReturn(this.atacarTableroMockTest03(atacante, paisAtacante, paisASerConquistadoDespues, 1));
        } catch(Exception e){
            return;
        }

        RondaAtaque rondaAtaque = new RondaAtaque(tableroMock, null);

        //Map<String, String> outMap = new HashMap<>();

        rondaAtaque.atacar(atacante,paisAtacante,paisASerConquistadoPrimero,1);
        rondaAtaque.atacar(atacante,paisAtacante,paisASerConquistadoDespues,1);
        assertTrue(atacante.getPaisesConquistados().contains(paisASerConquistadoPrimero));
        assertTrue(atacante.getPaisesConquistados().contains(paisASerConquistadoDespues));


    }



}
