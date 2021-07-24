package algoteg.PruebasUnitarias;
import algoteg.modelo.Dado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class DadoTest {

    @Test
    public void unDadoEsMayorQueDadoCero(){
        Dado dado0 = mock(Dado.class);
        when(dado0.getValor()).thenReturn(0);
        Dado dado = new Dado();

        assertTrue(dado.esMayorQue(dado0));
    }

}
