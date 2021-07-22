package algoteg.PruebasUnitarias;

import algoteg.Jugador;
import algoteg.Objetivo;
import algoteg.ObjetivoGeneral;
import algoteg.Pais;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ObjetivoGeneralTest {
    Jugador jugador = new Jugador(1,"rojo");
    Jugador otroJugador = new Jugador(2, "azul");

    @Test
    public void cumpleObjetivoDominarTreintaPaises() {
        for(int i = 0; i < 30; i++) {
            Pais paisMock = mock(Pais.class);
            jugador.addPaisConquistado(paisMock);
        }

        Objetivo objetivo = new ObjetivoGeneral(jugador);
        assertTrue(objetivo.cumplido());
    }

    @Test
    public void noCumpleObjetivoDominarTreintaPaises() {
        for(int i = 0; i < 20; i++) {
            Pais paisMock = mock(Pais.class);
            otroJugador.addPaisConquistado(paisMock);
        }

        Objetivo otroObjetivo = new ObjetivoGeneral(otroJugador);

        assertFalse(otroObjetivo.cumplido());
    }
}