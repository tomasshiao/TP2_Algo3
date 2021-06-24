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
    public void alAtacarSinArmasPierdeSalud() {
        Heroe heroe = new Heroe();
        int puntosDeSaludIniciales = heroe.puntosDeSalud();
        int puntosDeSaludDelEnemigo = 3;
        Enemigo enemigo = new Enemigo(puntosDeSaludDelEnemigo);

        heroe.atacar(enemigo);

        assertEquals(heroe.puntosDeSalud(), puntosDeSaludIniciales - puntosDeSaludDelEnemigo);
    }

    @Test
    public void alAtacarSinArmasElEnemigoMuere() {
        Heroe heroe = new Heroe();
        Enemigo enemigo = new Enemigo(3);

        heroe.atacar(enemigo);

        assertEquals(enemigo.puntosDeSalud(), 0);
    }


    @Test
    public void alAtacarSinArmasSiElEnemigoEsMuyFuerteElHeroeMuere() {
        Heroe heroe = new Heroe();
        Enemigo enemigo = new Enemigo(11);

        heroe.atacar(enemigo);

        assertEquals(heroe.puntosDeSalud(), 0);
    }

    @Test
    public void alAtacarSinArmasSiElEnemigoEsMuyFuerteElEnemigoNoMuere() {
        Heroe heroe = new Heroe();
        Enemigo enemigo = new Enemigo(11);

        heroe.atacar(enemigo);

        assertEquals(enemigo.puntosDeSalud(), 1);
    }
}