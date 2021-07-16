package algoteg;

import java.util.ArrayList;
import algoteg.Exceptions.PaisNoLePerteneceAlJugador;

public class Jugador {
    private String color;
    private int id;
    private ArrayList<Tarjeta> tarjetas = new ArrayList<>();
    private ArrayList<Pais> paisesConquistados = new ArrayList<>();
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

    private void removeTarjeta(Tarjeta tarjeta){
        int index = 0;
        int i = 0;
        for(Tarjeta a: tarjetas) {
            if (a == tarjeta)
                index = i;
            i++;
        }
        tarjetas.remove(index);
    }

    public int getTarjetasEnSuPoder(){
        return tarjetas.size();
    }

    private void addEjercito(int ejercitoParaIncorporar){
        this.ejercitoParaIncorporar += ejercitoParaIncorporar;
    }

    public void addEjercitoEnPais(Pais pais, int ejercito){
        if(paisesConquistados.contains(pais) && this.ejercitoParaIncorporar >= ejercito){
            pais.agregarEjercito(ejercito);
            this.ejercitoParaIncorporar -= ejercito;
        }
    }

    public int getEjercitoParaIncorporar(){
        return ejercitoParaIncorporar;
    }

    public boolean canjearTarjetas(Tarjeta tarjeta1, Tarjeta tarjeta2, Tarjeta tarjeta3){
        if (tarjeta1.compararTarjetas(tarjeta2, tarjeta3)) {
            this.addEjercito(4);
            this.removeTarjeta(tarjeta1);
            this.removeTarjeta(tarjeta2);
            this.removeTarjeta(tarjeta3);
            return true;
        }
        return false;
    }

    public boolean compararJugadores(Jugador jugador2) { return (this.getColor().equals(jugador2.getColor())); }

    public void activarTarjeta (Tarjeta tarjeta){
        Pais paisDeTarjeta = tarjeta.getPaisDeTarjeta();
        int ejercitoAIncorporar = 0;

        if(this.paisesConquistados.contains(paisDeTarjeta) && this.tarjetas.contains(tarjeta))
            ejercitoAIncorporar = tarjeta.activarTarjeta();
        addEjercito(ejercitoAIncorporar);
    }

    public void addPaisConquistado(Pais pais){
        paisesConquistados.add(pais);
    }

}