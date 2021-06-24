package edu.fiuba.algo3.modelo;

public class Enemigo {
    private final Salud puntosDeDanioYSalud;

    public Enemigo(int puntosDeDanioYSalud) {
        this.puntosDeDanioYSalud = new Salud(puntosDeDanioYSalud);
    }

    public int puntosDeDanio() {
        return this.puntosDeDanioYSalud.puntos();
    }

    public int puntosDeSalud() {
        return this.puntosDeDanioYSalud.puntos();
    }

    public void daniar(int danio) {
        this.puntosDeDanioYSalud.disminuir(danio);
    }
}
