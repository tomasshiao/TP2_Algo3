package algoteg.PruebasExcepciones;

import algoteg.Exceptions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class AtaqueInvalidoExceptionTest {
    private String defualtKey = "AtaqueInvalido";
    private String noLimitrofeKey = "NoLimitrofe";
    private String tropasInsuficientesKey = "TropasInsuficientes";
    private String paisNoMePerteneceKey = "PaisNoMePertenece";
    private String conquistarPaisPropioKey = "ConquistarPaisPropio";

    private String noLimitrofeCaseChangeKey = "nOlIMITROFE";
    private String tropasInsuficientesCaseChangeKey = "tROPASiNSUFICIENTES";
    private String paisNoMePerteneceCaseChangeKey = "pAISnOmEpERTENECE";
    private String conquistarPaisPropioCaseChangeKey = "cONQUISTARpAISpROPIO";
    
    private String noLimitrofeMessage = "No se puede atacar a un país que no es límitrofe.";
    private String tropasInsuficientesMessage = "No tiene tropas suficientes para atacar.";
    private String paisNoMePerteneceMessage = "No puede atacar desde un país que no le pertenece.";
    private String conquistarPaisPropioMessage = "No puede conquistar un país que ya le pertenece.";
    private String defaultMessage = "Ataque inválido";


    /****************
     * Test Get Mensajes
    *****************/

    @Test
    public void alElevarseLaExcepcionesConMensajeCorrectoDevuelveElMensajePorDefecto(){
        AtaqueInvalidoException ataqueInvalidoDefault = new AtaqueInvalidoException(defualtKey);
        assertEquals(defaultMessage, ataqueInvalidoDefault.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionCpmMensajeNoLimitrofeDevuelveElMensajeCorrecto(){
        AtaqueInvalidoException ataqueInvalidoNoLimitrofe = new AtaqueInvalidoException(noLimitrofeKey);
        assertEquals(noLimitrofeMessage, ataqueInvalidoNoLimitrofe.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionConMensajeTropasInsuficientesCorrectoDevuelveElMensajeCorrecto(){
        AtaqueInvalidoException ataqueInvalidoTropasInsuficientes = new AtaqueInvalidoException(tropasInsuficientesKey);
        assertEquals(tropasInsuficientesMessage, ataqueInvalidoTropasInsuficientes.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionConMensajePaisNoMePerteneceCorrectoDevuelveElMensajeCorrecto(){
        AtaqueInvalidoException ataqueInvalidoPaisNoMePertenece = new AtaqueInvalidoException(paisNoMePerteneceKey);
        assertEquals(paisNoMePerteneceMessage, ataqueInvalidoPaisNoMePertenece.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionConMensajeConquistarPaisPropioCorrectoDevuelveElMensajeCorrecto(){
        AtaqueInvalidoException ataqueInvalidoConquistarPaisPropio = new AtaqueInvalidoException(conquistarPaisPropioKey);
        assertEquals(conquistarPaisPropioMessage, ataqueInvalidoConquistarPaisPropio.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionConMensajeNoLimitrofeIncorrectoDevuelveElMensajeInorrecto(){
        AtaqueInvalidoException ataqueInvalidoNoLimitrofe = new AtaqueInvalidoException(noLimitrofeCaseChangeKey);
        assertEquals(defaultMessage, ataqueInvalidoNoLimitrofe.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionConMensajeTropasInsuficientesIncorrectoDevuelveElMensajeIncorrecto(){
        AtaqueInvalidoException ataqueInvalidoTropasInsuficientes = new AtaqueInvalidoException(tropasInsuficientesCaseChangeKey);
        assertEquals(defaultMessage, ataqueInvalidoTropasInsuficientes.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionConMensajePaisNoMePerteneceIncorrectoDevuelveElMensajeIncorrecto(){
        AtaqueInvalidoException ataqueInvalidoPaisNoMePertenece = new AtaqueInvalidoException(paisNoMePerteneceCaseChangeKey);
        assertEquals(defaultMessage, ataqueInvalidoPaisNoMePertenece.getMessage());
    }

    @Test
    public void alElevarseLaExcepcionConMensajeConquistarPaisPropioIncorrectoDevuelveElMensajeIncorrecto(){
        AtaqueInvalidoException ataqueInvalidoConquistarPaisPropio = new AtaqueInvalidoException(conquistarPaisPropioCaseChangeKey);
        assertEquals(defaultMessage, ataqueInvalidoConquistarPaisPropio.getMessage());
    }
    
}
