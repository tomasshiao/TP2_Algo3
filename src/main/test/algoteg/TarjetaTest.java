package algoteg;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TarjetaTest {
    public List<Pais> getSetUpData(){
        Jugador jugador = new Jugador(0, "color");
        List<String> paisesString = new ArrayList<>(Arrays.asList("Argentina", "Alemania", "Japon", "Espania","Uruguay"));
        List<Pais> paises = new ArrayList<>();
        for (String s : paisesString) {
            Pais p = new Pais(s, jugador);
            paises.add(p);
        }
        return paises;
    }
    List<Pais> paises = this.getSetUpData();
    Tarjeta tarjetaArg = new Tarjeta(paises.get(0), "Barco");
    Tarjeta tarjetaAle = new Tarjeta(paises.get(1), "Barco");
    Tarjeta tarjetaJap = new Tarjeta(paises.get(2), "Barco");
    Tarjeta tarjetaEsp = new Tarjeta(paises.get(3), "Canion");
    Tarjeta tarjetaUru = new Tarjeta(paises.get(4), "Globo");

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