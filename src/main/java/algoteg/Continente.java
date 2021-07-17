package algoteg;

import java.util.*;



public class Continente {

    List<Pais> paises;
    String nombre;
    Jugador jugador;

    public Continente(String nombreContinente){
        this.nombre = nombreContinente;
    }


    public void setPaises(List<Pais> listaPaises) {
        this.paises = listaPaises;
    }

    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }

    public boolean esGobernante(String colorGobernante){
        return (jugador.getColor().equals(colorGobernante));
    }



}
