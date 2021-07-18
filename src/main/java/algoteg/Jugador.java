package algoteg;

import java.util.ArrayList;
import java.util.List;

import algoteg.Exceptions.PaisNoLePerteneceAlJugador;

public class Jugador {
    private String color;
    private int id;
    private List<Tarjeta> tarjetas = new ArrayList<>();
    private List<Pais> paisesConquistados = new ArrayList<>();
    private List<Objetivo> objetivos = new ArrayList<>();
    private int ejercitoParaIncorporar;
    private int canjesRealizados;

    public Jugador(int id, String color) {
        this.id = id;
        this.color = color;
        this.ejercitoParaIncorporar = 0;
        this.canjesRealizados = 0;
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

    public boolean esGanador(){return false;} // se fija si cumple objetivos

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
            this.canjesRealizados++;
            int ejercitoAIncorporar = this.calcluarEjercitoSegunCanjes();
            this.addEjercito(ejercitoAIncorporar);
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


    private int calcluarEjercitoSegunCanjes(){
        int ejercitoAIncorporar;

        if(this.canjesRealizados == 0) return 0;

        switch(this.canjesRealizados){
            case 1: {
                ejercitoAIncorporar = 4;
                break;
            }
            case 2: {
                ejercitoAIncorporar = 7;
                break;
            }
            case 3: {
                ejercitoAIncorporar = 10;
                break;
            }
            default:
                ejercitoAIncorporar = (this.canjesRealizados-1)*5;
        }
        return ejercitoAIncorporar;
    }

    public int getCantidadPaisesConquistados() {
        return (paisesConquistados.size());
    }

    public void setPaises(List<Pais> listaPaises) {
        this.paisesConquistados = listaPaises;
    }
    public void agregarPaisInicial(Pais pais){
        this.paisesConquistados.add(pais);
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }
}