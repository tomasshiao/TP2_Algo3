package algoteg;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaisTest {
    Jugador unJugador = new Jugador(1, "azul");
    Jugador otroJugador = new Jugador(2, "rojo");
    Pais paisAtacante = new Pais("Argentina", unJugador);
    Pais paisDefensor = new Pais("Uruguay", otroJugador);
    Pais unPais = new Pais("Brasil",unJugador);
    Batalla batalla = new Batalla();

    @Test
    public void colocaUnEjercitoEnPais(){
        unPais.agregarEjercito(1);

        assertEquals(1, unPais.getEjercitoActual());
    }

    @Test
    public void quedanDosEjercitosAlColocaTresEjercitosyQuitarUno(){
        unPais.agregarEjercito(3);
        unPais.reducirEjercito(1);

        assertEquals(2, unPais.getEjercitoActual());
    }


    @Test
    public void ganaDefensor(){
        paisDefensor.setJugador(unJugador);
        paisAtacante.setJugador(otroJugador);
        paisAtacante.agregarEjercito(1);
        paisDefensor.agregarEjercito(1);

        List<Integer> dadosAtacante = new ArrayList<>();
        dadosAtacante.add(1);
        List<Integer> dadosDefensor = new ArrayList<>();
        dadosDefensor.add(6);
        dadosDefensor.add(6);
        Pais victorioso = batalla.obtenerVictoriosoDeGuerra(dadosAtacante,dadosDefensor,paisAtacante, paisDefensor);

        assertEquals("Uruguay", victorioso.getNombre());
    }
    @Test
    public void ganaAtacanteYLoOcupa(){
        paisDefensor.setJugador(unJugador);
        paisAtacante.setJugador(otroJugador);

        paisAtacante.agregarEjercito(1);
        paisDefensor.agregarEjercito(1);

        List<Integer> dadosAtacante = new ArrayList<>();
        dadosAtacante.add(6);
        List<Integer> dadosDefensor = new ArrayList<>();
        dadosDefensor.add(2);
        dadosDefensor.add(1);
        Pais victorioso = batalla.obtenerVictoriosoDeGuerra(dadosAtacante,dadosDefensor,paisAtacante, paisDefensor);

        assertEquals("Argentina", victorioso.getNombre());
        assertEquals(1,paisDefensor.getEjercitoActual());

    }


}