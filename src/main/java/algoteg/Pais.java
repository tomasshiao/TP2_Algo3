package algoteg;

import java.util.*;

public class Pais {

    String nombre;
    int cantidadEjercito;
    Jugador jugador;
    List<Pais> paisesLimitrofes;

    public Pais(String nombre, Jugador ocupante){
        this.nombre = nombre;
        this.jugador = ocupante;
        cantidadEjercito = 0;
    }

    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }

    public void setPaisesLimitrofes(List<Pais> listaPaises) {
        this.paisesLimitrofes = listaPaises;
    }

    public void agregarEjercito(int cantidad){
        cantidadEjercito += cantidad;
    }

    public void reducirEjercito(int cantidad){
        cantidadEjercito -= cantidad;
    }

    public int getEjercitoActual(){
        return this.cantidadEjercito;
    }

    public String getNombre(){ return this.nombre;}

    public boolean noTengoTropas(){
        return (this.cantidadEjercito == 0);
    }
    private void conquistar(Jugador jugador){
        if(this.noTengoTropas()){
            this.agregarEjercito(1);
            this.setJugador(jugador);
        }
    }

    public void ocupar(Pais paisDefensor){
        paisDefensor.conquistar(this.jugador);
    }

    public boolean esGobernante(String color){
        return (color.equals( jugador.getColor()));
    }
}
