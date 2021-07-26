package algoteg.PruebasExcepciones;

import algoteg.Exceptions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;


public class MoverEjercitoExceptionTest {
    private String noLimitrofeMessage = "No se puede mover tropas a un país que no es límitrofe.";
    private String tropasInsuficientesMessage = "No puede mover esa cantidad de tropas.";
    private String paisNoMePerteneceMessage = "No puede mover tropas a un país que no le pertenece.";
    private String defaultMessage = "Movimiento no permitido.";

    private String defualtKey = "MovimientoInvalido";
    private String noLimitrofeKey = "NoLimitrofe";
    private String tropasInsuficientesKey = "TropasInsuficientes";
    private String paisNoMePerteneceKey = "PaisNoMePertenece";

    private String noLimitrofeCaseChangeKey = "nOlIMITROFE";
    private String tropasInsuficientesCaseChangeKey = "tROPASiNSUFICIENTES";
    private String paisNoMePerteneceCaseChangeKey = "pAISnOmEpERTENECE";
    
    public void alElevarseLaExcepcionesConMensajeCorrectoDevuelveElMensajePorDefecto(){
        MoverEjercitoException MoverEjercitoDefault = new MoverEjercitoException(defualtKey);
        assertEquals(defaultMessage, MoverEjercitoDefault.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionCpmMensajeNoLimitrofeDevuelveElMensajeCorrecto(){
        MoverEjercitoException MoverEjercitoNoLimitrofe = new MoverEjercitoException(noLimitrofeKey);
        assertEquals(noLimitrofeMessage, MoverEjercitoNoLimitrofe.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionConMensajeTropasInsuficientesCorrectoDevuelveElMensajeCorrecto(){
        MoverEjercitoException MoverEjercitoTropasInsuficientes = new MoverEjercitoException(tropasInsuficientesKey);
        assertEquals(tropasInsuficientesMessage, MoverEjercitoTropasInsuficientes.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionConMensajePaisNoMePerteneceCorrectoDevuelveElMensajeCorrecto(){
        MoverEjercitoException MoverEjercitoPaisNoMePertenece = new MoverEjercitoException(paisNoMePerteneceKey);
        assertEquals(paisNoMePerteneceMessage, MoverEjercitoPaisNoMePertenece.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionConMensajeNoLimitrofeIncorrectoDevuelveElMensajeInorrecto(){
        MoverEjercitoException MoverEjercitoNoLimitrofe = new MoverEjercitoException(noLimitrofeCaseChangeKey);
        assertEquals(defaultMessage, MoverEjercitoNoLimitrofe.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionConMensajeTropasInsuficientesIncorrectoDevuelveElMensajeIncorrecto(){
        MoverEjercitoException MoverEjercitoTropasInsuficientes = new MoverEjercitoException(tropasInsuficientesCaseChangeKey);
        assertEquals(defaultMessage, MoverEjercitoTropasInsuficientes.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionConMensajePaisNoMePerteneceIncorrectoDevuelveElMensajeIncorrecto(){
        MoverEjercitoException MoverEjercitoPaisNoMePertenece = new MoverEjercitoException(paisNoMePerteneceCaseChangeKey);
        assertEquals(defaultMessage, MoverEjercitoPaisNoMePertenece.getMessage());
    }
}
