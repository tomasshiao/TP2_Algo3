package algoteg;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaisTest {
    Pais paisAtacante = new Pais("Argentina");
    Pais paisDefensor = new Pais("Uruguay");
    Batalla batalla = new Batalla();


    @Test
    public void ganaDefensor(){
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