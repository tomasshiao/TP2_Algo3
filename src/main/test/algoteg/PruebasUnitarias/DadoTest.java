package algoteg.PruebasUnitarias;
import algoteg.Dado;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class DadoTest {

    @Test
    public void dadoSeisEsMayorQue5(){
        Dado dado0 = mock(Dado.class);
        when(dado0.getValor()).thenReturn(0);
        Dado dado = new Dado();

        assertTrue(dado.esMayorQue(dado0));
    }

}
