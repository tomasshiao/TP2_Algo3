package algoteg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TarjetaTest {
    Tarjeta tarjetaArg = new Tarjeta("Argentina", "Barco");
    Tarjeta tarjetaAle = new Tarjeta("Alemania", "Barco");
    Tarjeta tarjetaJap = new Tarjeta("Japon", "Barco");
    Tarjeta tarjetaEsp = new Tarjeta("Espania", "Canion");
    Tarjeta tarjetaUru = new Tarjeta("Uruguay", "Globo");

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
