package algoteg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TarjetaTest {

    Pais paisMock = mock(Pais.class);

    Tarjeta tarjetaArg = new Tarjeta(paisMock, "Barco");
    Tarjeta tarjetaAle = new Tarjeta(paisMock, "Barco");
    Tarjeta tarjetaJap = new Tarjeta(paisMock, "Barco");
    Tarjeta tarjetaEsp = new Tarjeta(paisMock, "Canion");
    Tarjeta tarjetaUru = new Tarjeta(paisMock, "Globo");


    @Test
    public void seComparanTresTarjetasDeIgualDibujo(){

        boolean comparar = tarjetaArg.compararTarjetas(tarjetaAle, tarjetaJap);

        assertTrue(comparar);
    }

    @Test
    public void seComparanTresTarjetasDeDiferenteDibujo(){
        boolean comparar = tarjetaArg.compararTarjetas(tarjetaEsp, tarjetaUru);

        assertTrue(comparar);
    }

    @Test
    public void seComparanDosTarjetasIgualesYUnaDistinta(){
        boolean comparar = tarjetaArg.compararTarjetas(tarjetaAle, tarjetaEsp);

        assertFalse(comparar);
    }

    @Test
    public void seActivaUnaTarjetaYSuEstadoPasaAActivada(){
        tarjetaArg.activarTarjeta();
        boolean estado = tarjetaArg.getActivada();

        assertTrue(estado);
    }

    @Test
    public void seActivaTarjetaYAlCompararseConOtrasIgualesSuEstadoPasaASerDesactivada(){
        tarjetaArg.activarTarjeta();
        tarjetaArg.compararTarjetas(tarjetaEsp, tarjetaUru);
        boolean estado = tarjetaArg.getActivada();

        assertFalse(estado);
    }


}

