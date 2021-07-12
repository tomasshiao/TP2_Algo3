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
    public void Pais(){
        paisAtacante.agregarEjercito(1);
        paisDefensor.agregarEjercito(1);

        List<Integer> dadosAtacante = new ArrayList<Integer>();
        dadosAtacante.add(1);
        List<Integer> dadosDefensor = new ArrayList<Integer>();
        dadosDefensor.add(6);
        dadosDefensor.add(6);
        Pais victorioso = batalla.obtenerVictoriosoDeGuerra(dadosAtacante,dadosDefensor,paisAtacante, paisDefensor);

        assertEquals("Uruguay", victorioso.getNombre());
    }


}