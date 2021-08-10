package algoteg.PruebasUnitarias;

import algoteg.modelo.Batalla;
import algoteg.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JuegoTest {

    @Test

    public void seAgreganJugadores() {
        Partida partida = new Partida(3);

        partida.agregarJugador(new Jugador(1, "000000"));
        partida.agregarJugador(new Jugador(2, "009988"));

        List<String> jugadores = partida.getOrdenJugadores();
        assertEquals("009988",jugadores.get(1));
    }
}
