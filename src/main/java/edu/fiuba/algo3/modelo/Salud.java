package edu.fiuba.algo3.modelo;

public class Salud {
    private int puntos;

    public Salud(int puntos) {
        this.puntos = puntos;
    }

    public int puntos() {
        return this.puntos;
    }

    public void disminuir(int puntos) {
        this.puntos -= puntos;
    }
}
