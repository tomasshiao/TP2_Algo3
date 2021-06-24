package edu.fiuba.algo3.modelo;

public class Heroe {
    private final Salud salud;

    public Heroe() {
        this.salud = new Salud(10);
    }

    public int puntosDeSalud() {
        return this.salud.puntos();
    }

    public void atacar(Enemigo enemigo) {
        int danio = Math.min(this.salud.puntos(), enemigo.puntosDeDanio());

        this.salud.disminuir(danio);
        enemigo.daniar(danio);
    }
}
