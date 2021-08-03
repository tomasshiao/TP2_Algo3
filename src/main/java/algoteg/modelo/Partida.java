package algoteg.modelo;

import algoteg.Exceptions.AtaqueInvalidoException;
import algoteg.datosJuego.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.*;

public class Partida {

    private int cantidadTotalJugadores;
    private int cantidadJugadoresActuales;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Tablero tablero;
    private List<Objetivo> objetivos = new ArrayList<>();
    private LanzadorDados lanzadorDados = new LanzadorDados();
    private List<Ronda> rondas = new ArrayList<>();
    private Integer indiceJugadorActual;

    public Partida(int cantidadTotalJugadores) {
        cantidadJugadoresActuales = 0;
        this.cantidadTotalJugadores = Math.min(cantidadTotalJugadores, 6);
        this.indiceJugadorActual = 0;
    }

    public void pasarAJugadorSiguiente(){
        if(this.indiceJugadorActual == (cantidadJugadoresActuales-1)){
            this.indiceJugadorActual = 0;
        }
        else {
            this.indiceJugadorActual++;
        }
    }
    public Jugador getJugadorActual(){
        return jugadores.get(this.indiceJugadorActual);
    }
    public void agregarJugador(Jugador unJugador) {
        if (jugadores.size() < this.cantidadTotalJugadores) {
            jugadores.add(unJugador);
            this.cantidadJugadoresActuales++;
        }
    }

    public int getCantidadJugadoresActuales() {
        return cantidadJugadoresActuales;
    }

    public int getCantidadDeRondasJugadas(){
        return this.rondas.size();
    }

    public void inicializarJugadores(Integer cantdiadJugadores){
        
    }

    public void iniciarPartida() {
        List<Pais> paises = this.iniciarPaisesYContinentes();
        this.iniciarTarjetas(paises);
        inicializarObjetivos();
    }

    private List<Pais> iniciarPaisesYContinentes() {
        InitializePaisesYContinentes init = new InitializePaisesYContinentes();
        this.tablero = new Tablero(init.getTodosLosContinentes(), init.getTodosLosPaises(), lanzadorDados); //inicializa tablero
        repartirPaises(init.getTodosLosPaises());
        return init.getTodosLosPaises();
    }

    private void iniciarTarjetas(List<Pais> paises) {
        InitializeTarjetas init = new InitializeTarjetas(paises);
        List<Tarjeta> tarjetas = init.getTodasLasTarjetas();
        Collections.shuffle(tarjetas);
//        this.repartirTarjetas(tarjetas);
    }

   /* private void repartirTarjetas(List<Tarjeta> tarjetas) { //no se usa
        int i = 0;
        for (Jugador jugador : jugadores) {

            jugador.setTarjetas(tarjetas.subList(i, i + 3));
            i++;

        }
    }*/

    private void repartirPaises(List<Pais> paises) {
        Collections.shuffle(paises);  //mezcla paises
        int cantidadPaises = 50;
        int cantidadCartas = cantidadPaises / cantidadTotalJugadores;
        int i = 0;
        for (Jugador jugador : this.jugadores) {
            List<Pais> paisesDeJugador = paises.subList(i, i + cantidadCartas);
            i += cantidadCartas;
            paisesDeJugador.forEach(pais -> {
                pais.setJugador(jugador); //agrego jugador como gobernante del pais
                pais.agregarEjercito(1); //agrega 1 tropa al pais
            });
            jugador.setPaises(paisesDeJugador);
        }

        if (cantidadPaises % cantidadTotalJugadores != 0) { // Siempre da resto 0 o 2 independientemente de la cantidad de jugadores
            Pais ultimoPais = paises.get(cantidadPaises - 1);
            Pais anteultimoPais = paises.get(cantidadPaises - 2);
            Jugador ultimoJugador = jugadores.get(cantidadTotalJugadores - 1);
            Jugador anteultimoJugador = jugadores.get(cantidadTotalJugadores - 2);
            ultimoPais.setJugador(ultimoJugador);
            anteultimoPais.setJugador(anteultimoJugador);
            ultimoJugador.agregarPaisInicial(ultimoPais);
            anteultimoJugador.agregarPaisInicial(anteultimoPais);
        }

    }

    private void inicializarObjetivos(){
        InitializeObjetivos initObjetivos = new InitializeObjetivos(this.jugadores, this.tablero);
        this.objetivos = initObjetivos.getObjetivos();
        repartirObjetivos();
    }

    private void repartirObjetivos(){
        Collections.shuffle(this.objetivos);
        int i = 0;
        for(Jugador jugador: jugadores){
            jugador.setObjetivo(this.objetivos.get(i));
            i++;
        }
    }

    public List<Objetivo> getObjetivos(){
        return this.objetivos;
    }

    public Map<String, Object> toDTO(){
        Map<String, Object> dto = new HashMap<>();
        dto.put("Jugadores", this.jugadores);
        dto.put("Tablero", this.tablero);
        return dto;
    }

    public void atacar(Pais paisAtacante, Pais paisDefensor, int numeroTropas) throws AtaqueInvalidoException {
        RondaAtaque ronda = new RondaAtaque(tablero, this.getJugadorActual());
        ronda.atacar(paisAtacante,paisDefensor,numeroTropas);

    }

    public void mover(Pais paisOrigen, Pais paisDestino, int numeroTropas) {
        RondaAtaque ronda = new RondaAtaque(tablero, this.getJugadorActual());
        ronda.moverEjercito(paisOrigen,paisDestino,numeroTropas);
    }



}
