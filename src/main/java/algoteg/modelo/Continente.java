package algoteg.modelo;

import java.util.*;



public class Continente {

    List<Pais> paises;
    String nombre;
    int bonusTropas;

    public Continente(String nombreContinente, int bonusTropas){
        this.nombre = nombreContinente;
        this.bonusTropas = bonusTropas;
    }

    public void setPaises(List<Pais> listaPaises) {
        this.paises = listaPaises;
    }

    public boolean tienePais(Pais pais){
        return this.paises.contains(pais);
    }

    public boolean esGobernante(Jugador jugador){
        boolean esGobernante = true;
        for (Pais pais : paises) {
            if(!pais.esGobernadoPor(jugador)) {
                esGobernante = false;
            }
        }
        return esGobernante;
    }

    public List<Pais> getConquistadosPor(Jugador jugador) {
        List<Pais> paisesGobernados = new ArrayList<>();
        for (Pais pais : paises) {
            if(pais.esGobernadoPor(jugador)) {
                paisesGobernados.add(pais);
            }
        }
        return paisesGobernados;
    }

    public String getNombre(){
        return this.nombre;
    }

    public List<Pais> getPaises(){
        return this.paises;
    }

    public Pais getPais(String nombrePais){
        for(Pais p: this.getPaises())
            if(p.getNombre().equals(nombrePais))
                return p;
        return null;
        //implementar "paisNoEncontradoError"
    }

    public int getCantidadDePaises(){
        return paises.size();
    }

    public int getBonusTropas(){return bonusTropas;}

}
