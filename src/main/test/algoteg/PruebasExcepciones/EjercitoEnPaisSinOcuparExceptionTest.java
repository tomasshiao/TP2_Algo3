package algoteg.PruebasExcepciones;

import algoteg.Exceptions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;


public class EjercitoEnPaisSinOcuparExceptionTest {
    private String expectedMessage = "El país en el que quiso poner ejércitos no está ocupado";
    
    @Test
    public void elMensajeDeErrorQueDevuelveEsElEsperado(){
        EjercitoEnPaisSinOcuparException eepso = new EjercitoEnPaisSinOcuparException();
        assertEquals(expectedMessage, eepso.getMessage());
    }
}
