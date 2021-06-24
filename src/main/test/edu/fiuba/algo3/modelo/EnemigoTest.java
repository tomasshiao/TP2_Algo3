package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemigoTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 15, Integer.MAX_VALUE}) // six numbers
    public void ElEnemigoComienzaConTantosPuntosDeDanioComoSeIndiquePorParametro(int puntosDeDanio) {
        Enemigo enemigo = new Enemigo(puntosDeDanio);
        assertEquals(enemigo.puntosDeDanio(), puntosDeDanio);
    }

        @Test
    public void alAtacarAUnEnemigoSinArmasPierdeSalud() {
        Heroe heroe = new Heroe();
        int puntosDeSaludIniciales = heroe.puntosDeSalud();
        int puntosDeSaludDelEnemigo = 3;
        Enemigo enemigo = new Enemigo(puntosDeSaludDelEnemigo);

        heroe.atacar(enemigo);

        assertEquals(heroe.puntosDeSalud(), puntosDeSaludIniciales - puntosDeSaludDelEnemigo);
    }
}