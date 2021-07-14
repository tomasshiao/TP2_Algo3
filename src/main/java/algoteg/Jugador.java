package algoteg;

import java.util.ArrayList;

public class Jugador {
    private String color;
    private int id;
    private ArrayList<Tarjeta> tarjetas = new ArrayList<>();
    private int ejercitoParaIncorporar;

    public Jugador(int id, String color) {
        this.id = id;
        this.color = color;
        this.ejercitoParaIncorporar = 0;
    }

    public String getColor(){
        return color;
    }

    public int getId(){
        return id;
    }

    public void addTarjeta(Tarjeta tarjeta){
        tarjetas.add(tarjeta);
    }

    public void showTarjetas(){
        for(Tarjeta a: tarjetas)
            System.out.println(a.getNombrePais() + ": " + a.getDibujo());
    }

    public void canjearTarjetas(Tarjeta tarjeta1, Tarjeta tarjeta2, Tarjeta tarjeta3){
        if (tarjeta1.compararTarjetas(tarjeta2, tarjeta3))
            this.addEjercito(4);
    }

    public void addEjercito(int ejercitoParaIncorporar){
        this.ejercitoParaIncorporar += ejercitoParaIncorporar;
    }

    public int getEjercitoParaIncorporar(){
        return ejercitoParaIncorporar;
    }
}
