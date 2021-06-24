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
        int saludHeroe = this.salud.puntos();
        int saludEnemigo = enemigo.puntosDeDanio();
        int danio = Math.min(saludHeroe, saludEnemigo);

        this.salud.disminuir(danio);
        enemigo.daniar(danio);
    }
}
