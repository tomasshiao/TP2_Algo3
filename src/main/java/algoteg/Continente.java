package algoteg;

import java.util.*;



public class Continente {

    List<Pais> paises;
    String nombre;
    Jugador jugador;

    public Continente(String nombreContinente, int bonusTropas){
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

    public List<Pais> getConquistadosPor(String colorGobernante) {
        List<Pais> paisesGobernados = new ArrayList<>();
        for (Pais pais : paises) {
            if(pais.esGobernadoPor(colorGobernante)) {
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

}
