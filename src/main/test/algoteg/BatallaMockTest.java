package algoteg;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BatallaMockTest {

    BatallaMock batallaMock = new BatallaMock();



    @Test
    public void ganaAtacante(){

        Pais paisAtacanteMock = mock(Pais.class);
        when(paisAtacanteMock.getNombre()).thenReturn("Argentina");
        when(paisAtacanteMock.getEjercitoActual()).thenReturn(2);
        Pais paisDefensorMock = mock(Pais.class);
        when(paisDefensorMock.getNombre()).thenReturn("Uruguay");
        when(paisDefensorMock.getEjercitoActual()).thenReturn(1);


        Pais ganador = batallaMock.obtenerVictoriosoDeGuerra(paisAtacanteMock,paisDefensorMock);

        assertEquals("Argentina", ganador.getNombre());
    }


}