package edu.fiuba.algo3.modelo;

public class Enemigo {
    private int puntosDeDanioYSalud;

    public Enemigo(int puntosDeDanioYSalud) {
        this.puntosDeDanioYSalud = puntosDeDanioYSalud;
    }

    public int puntosDeDanio() {
        return this.puntosDeDanioYSalud;
    }

    public int puntosDeSalud() {
        return this.puntosDeDanioYSalud;
    }

    public void daniar(int danio) {
        this.puntosDeDanioYSalud -= danio;
    }
}
