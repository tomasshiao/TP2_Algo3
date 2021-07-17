package algoteg;

import java.util.*;



public class Continente {

    List<Pais> paises;
    String nombre;

    public Continente(String nombreContinente){
        this.nombre = nombreContinente;
    }


    public void setPaises(List<Pais> listaPaises) {
        this.paises = listaPaises;
    }



}
