package algoteg;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ObjetivoPorConquistaTest {
    Continente americaDelSur = new Continente("America del Sur");
    Continente americaDelNorte = new Continente("America del Norte");
    Jugador jugador = new Jugador(1,"rojo");
    Jugador otroJugador = new Jugador(2,"azul");
    Pais argentina = new Pais("Argentina", jugador);
    Pais uruguay = new Pais("Uruguay", jugador);
    Pais brasil = new Pais("Brasil", jugador);
    Pais chile = new Pais("Chile", otroJugador);
    Pais colombia = new Pais("Colombia", otroJugador);
    List<Pais> paisesAmericaDelSur = List.of(argentina,uruguay,brasil,chile,colombia);

    Pais alaska = new Pais("Alaska", jugador);
    Pais california = new Pais("California", jugador);
    Pais canada = new Pais("Canada", jugador);
    Pais nuevayork = new Pais("Nueva York", jugador);
    Pais groenlandia = new Pais("Groenlandia", otroJugador);
    List<Pais> paisesAmericaDelNorte = List.of(alaska,california,groenlandia,canada,nuevayork);




    @Test
    public void cumpleObjetivoConquistaPaises(){
        americaDelSur.setPaises(paisesAmericaDelSur);
        americaDelNorte.setPaises(paisesAmericaDelNorte);

        List<Continente> continentes = List.of(americaDelNorte,americaDelSur);
        List<Integer> cantidadDePaisesConquistados = List.of(4,3);
        Objetivo objetivo = new ObjetivoPorConquista(continentes,cantidadDePaisesConquistados);
        objetivo.setJugador(jugador);

        assertTrue(objetivo.cumplido());

    }
    @Test
    public void noCumpleObjetivoConquistaPaises(){
        americaDelSur.setPaises(paisesAmericaDelSur);
        americaDelNorte.setPaises(paisesAmericaDelNorte);

        List<Continente> continentes = List.of(americaDelNorte,americaDelSur);
        List<Integer> cantidadDePaisesConquistados = List.of(1,3);
        Objetivo objetivo = new ObjetivoPorConquista(continentes,cantidadDePaisesConquistados);
        objetivo.setJugador(otroJugador);

        assertFalse(objetivo.cumplido());
    }
}
