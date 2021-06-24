package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemigoTest {

    @Test
    public void losPuntosDeDanioSonIgualesALosDeSalud() {
        Enemigo enemigo = new Enemigo(10);

        assertEquals(enemigo.puntosDeSalud(), enemigo.puntosDeDanio());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 15, Integer.MAX_VALUE}) // six numbers
    public void comienzaConTantosPuntosDeDanioComoSeIndiquePorParametro(int puntosDeDanio) {
        Enemigo enemigo = new Enemigo(puntosDeDanio);
        assertEquals(enemigo.puntosDeDanio(), puntosDeDanio);
    }

    @Test
    public void pierdePuntosDeSaludCorrectamente() {
        Enemigo enemigo = new Enemigo(10);
        int puntosDeSaludIniciales = enemigo.puntosDeSalud();
        int danio = 3;

        enemigo.daniar(danio);

        assertEquals(enemigo.puntosDeSalud(), puntosDeSaludIniciales - danio);
    }
}