package algoteg.PruebasExcepciones;

import algoteg.Exceptions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class ContinenteInexistenteExceptionTest {
    private String expectedMessage = "El continente buscado no existe";

    @Test
    public void elMensajeDeExcepcionEsElEsperado(){
        ContinenteInexistenteException cie = new ContinenteInexistenteException();
        assertEquals(expectedMessage, cie.getMessage());
    }
}
