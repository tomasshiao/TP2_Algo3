package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroeTest {

    @Test
    public void comienzaCon10PuntosDeSalud() {
        Heroe heroe = new Heroe();
        assertEquals(heroe.puntosDeSalud(), 10);
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