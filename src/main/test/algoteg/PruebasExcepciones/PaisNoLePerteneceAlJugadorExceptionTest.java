package algoteg.PruebasExcepciones;

import algoteg.Exceptions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;


public class PaisNoLePerteneceAlJugadorExceptionTest {
    private String expectedMessage = "País de la tarjeta no te pertenece.";

    @Test
    public void elMensajeDeErrorQueDevuelveEsElEsperado(){
        PaisNoLePerteneceAlJugador pnlpaj = new PaisNoLePerteneceAlJugador();
        assertEquals(expectedMessage, pnlpaj.getMessage());
    }
}
