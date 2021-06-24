package edu.fiuba.algo3.modelo;

public class Enemigo {
    private int salud;
    private int danio;

    public Enemigo(int puntosDeDanioYSalud) {
        danio = puntosDeDanioYSalud;
        salud = puntosDeDanioYSalud;
    }

    public int puntosDeDanio() {
        return danio;
    }

    public int puntosDeSalud() {
        return salud;
    }

    public void daniar(int danio) {
        salud -= danio;
    }
}
