package algoteg;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarjetaTest {
    Partida unaPartida = new Partida(2);
    Jugador jugador1 = new Jugador(1, "azul");
    Tarjeta tarjetaArg = new Tarjeta("Argentina", "Barco");
    Tarjeta tarjetaAle = new Tarjeta("Alemania", "Barco");
    Tarjeta tarjetaJap = new Tarjeta("Japon", "Barco");
    Tarjeta tarjetaEsp = new Tarjeta("Espania", "Canion");
    Tarjeta tarjetaUru = new Tarjeta("Uruguay", "Globo");

    @Test
    public void unJugadorTieneTresTarjetasConMismoDibujoLasCanjeaYObtieneCuatroTropasACambio(){
        jugador1.addTarjeta(tarjetaAle);
        jugador1.addTarjeta(tarjetaArg);
        jugador1.addTarjeta(tarjetaJap);

        jugador1.canjearTarjetas(tarjetaArg, tarjetaJap, tarjetaAle);
        assertEquals(4, jugador1.getEjercitoParaIncorporar());
    }

    @Test
    public void unJugadorTieneTresTarjetasConDiferenteDibujoLasCanjeaYObtieneCuatroTropasACambio(){
        jugador1.addTarjeta(tarjetaArg);
        jugador1.addTarjeta(tarjetaEsp);
        jugador1.addTarjeta(tarjetaUru);

        jugador1.canjearTarjetas(tarjetaArg, tarjetaEsp, tarjetaUru);
        assertEquals(4, jugador1.getEjercitoParaIncorporar());
    }

    @Test
    public void unJugadorTieneDosTarjetasConIgualDibujoYUnaConDiferenteLasCanjeaYNoObtieneTropas(){
        jugador1.addTarjeta(tarjetaArg);
        jugador1.addTarjeta(tarjetaAle);
        jugador1.addTarjeta(tarjetaUru);

        jugador1.canjearTarjetas(tarjetaArg, tarjetaAle, tarjetaUru);
        assertEquals(0, jugador1.getEjercitoParaIncorporar());
    }
}
