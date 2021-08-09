package algoteg.modelo;

import algoteg.Exceptions.AtaqueInvalidoException;

import java.util.*;

public class Juego {
    Partida partida;
    List<String> colores = new ArrayList<>(List.of("#0077bb", "#cc3311", "#ee7733", "#009988","#ee3377","#000000"));



    public void iniciarJuegoConJugadores(Integer cantidadJugadores) {

        List<Jugador> jugadores = new ArrayList<>();
        Partida partida = new Partida(cantidadJugadores);
        this.partida = partida;
        Collections.shuffle(colores);


        //primero inicializo jugadores

        for (int i = 0; i < cantidadJugadores; i++) {
            partida.agregarJugador(new Jugador(i, colores.get(i)));
        }
        partida.iniciarPartida();

    }


    public void atacar(Pais paisAtacante, Pais paisDefensor, int cantidadTropas) throws AtaqueInvalidoException {
        partida.atacar(paisAtacante, paisDefensor, cantidadTropas);
    }

    public void mover(Pais paisOrigen, Pais paisLlegada, int cantidadTropas){
        partida.mover(paisOrigen, paisLlegada, cantidadTropas);
    }

    public int getCantidadJugadores(){
        return (partida.getCantidadJugadoresActuales());
    }

    public List<String> obtenerOrdenJugadores() {
        return partida.getOrdenJugadores();
    }

    public List<Objetivo> obtenerObjetivos() {
        return partida.getObjetivosDeJugadores();
    }

    public ArrayList<Jugador> getListaJugadores(){
        return this.partida.getListaJugadores();
    }

    public Pais getPaisPorNombre(String nombrePais) {
        return this.partida.getPaisPorNombre(nombrePais);
   }
   public void colocar(int cantTropas, String pais){
        partida.colocar(cantTropas,  pais);


   }

   public void pasarAJugadorSiguiente(){
        partida.pasarAJugadorSiguiente();
   }


   public boolean esTurnoDeColocacion(){
        return this.partida.esTurnoDeColocacion();
   }

    public boolean esTurnoDeAtaque(){
        return this.partida.esTurnoDeAtaque();
    }


    public int obtenerTropasEnPais(String pais) {
        return partida.obtenerTropasEnPais(pais);
    }

    public int getIndiceJugadorActual() {return partida.getIndiceJugadorActual();}

    public Jugador getJugadorActual() {return partida.getJugadorActual();}


    public String getTropasPorContinente(String nombreContinente){
        return String.valueOf(this.getJugadorActual().getTropasContinente(nombreContinente));
    }

    public void reagrupar(String paisSalida, String paisLlegada, int cantTropas){

        this.partida.mover(this.getPaisPorNombre(paisSalida), this.getPaisPorNombre(paisLlegada), cantTropas);
    }

    /*public int getTropasAsia(){
        return (this.getJugadorActual().getTropasContinente("Asia"));
    }

    public int getTropasAmericaDelSur(){
        return this.getJugadorActual().getTropasContinente("AmericaDelSur");
    }
    public int getTropasAmericaDelNorte(){
        return this.getJugadorActual().getTropasContinente("AmericaDelNorte");
    }
    public int getTropasAfrica(){
        return this.getJugadorActual().getTropasContinente("Africa");
    }
    public int getTropasEuropa(){
        return this.getJugadorActual().getTropasContinente("Europa");
    }
    public int getTropasOceania(){
        return this.getJugadorActual().getTropasContinente("Oceania");
    }*/
    public int getTropasGlobales(){
        return this.getJugadorActual().getTropasGlobales();
    }


}
