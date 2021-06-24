package edu.fiuba.algo3.modelo;

public class Heroe {
    private int salud = 10;

    public int puntosDeSalud() {
        return salud;
    }

    public void atacar(Enemigo enemigo) {
        salud -= enemigo.puntosDeDanio();
    }
}
