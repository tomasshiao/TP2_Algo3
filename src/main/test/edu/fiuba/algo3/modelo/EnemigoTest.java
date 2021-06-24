package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemigoTest {

    @Test
    public void ElEnemigoComienzaConTantosPuntosDeDanioComoSeIndiquePorParametro() {
        int puntosDeDanio = 3;
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