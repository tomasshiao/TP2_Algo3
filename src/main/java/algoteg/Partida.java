package algoteg;
import algoteg.datosJuego.InitializeObjetivos;
import algoteg.datosJuego.InitializePaisesYContinentes;
import algoteg.datosJuego.InitializeTarjetas;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class Partida {

    private int cantidadTotalJugadores;
    private int cantidadJugadoresActuales;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Tablero tablero = new Tablero();
    private List<Objetivo> objetivos = new ArrayList<>();
    private int ronda;
    private List<Ronda> rondas = new ArrayList<>();

    public Partida(int cantidadTotalJugadores) {
        cantidadJugadoresActuales = 0;
        ronda = 0;
        this.cantidadTotalJugadores = Math.min(cantidadTotalJugadores, 6);
    }

    public void agregarJugador(Jugador unJugador) {
        int idJugador = unJugador.getId();
        if (jugadores.size() < this.cantidadTotalJugadores) {
            jugadores.add(unJugador);
            this.cantidadJugadoresActuales++;
        }
    }

    public int getCantidadJugadoresActuales() {
        return cantidadJugadoresActuales;
    }

    private void pasarRonda() {
        this.ronda++;
    }

    /*private Jugador iniciarRonda() {
        int i = 0;
        int posicionGanador = i - 1;
        boolean hayGanador = false;
        while (!hayGanador & i < cantidadTotalJugadores) {
            //acciones jugador
            hayGanador = jugadores.get(i).esGanador();
            i++;
        }

        return jugadores.get(posicionGanador);
    }
*/
    public void iniciarPartida() {
        List<Pais> paises = this.iniciarPaisesYContinentes();
        this.iniciarTarjetas(paises);
        inicializarObjetivos();
        boolean hayGanador = true;
        while (!hayGanador) {
            Ronda rondaActual = new Ronda(this.toDTO());
            hayGanador = rondaActual.iniciarRonda();
            //hayGanador = iniciarRonda().esGanador();
        }
    }


    private List<Pais> iniciarPaisesYContinentes() {
        InitializePaisesYContinentes init = new InitializePaisesYContinentes();
        this.tablero.setContinentes(init.getTodosLosContinentes());
        this.tablero.setPaises(init.getTodosLosPaises());
        repartirPaises(init.getTodosLosPaises());
        return init.getTodosLosPaises();
    }

    private void iniciarTarjetas(List<Pais> paises) {
        InitializeTarjetas init = new InitializeTarjetas(paises);
        List<Tarjeta> tarjetas = init.getTodasLasTarjetas();
        Collections.shuffle(tarjetas);
        this.repartirTarjetas(tarjetas);
    }

    private void repartirTarjetas(List<Tarjeta> tarjetas) {
        int i = 0;
        for (Jugador jugador : jugadores) {

            jugador.setTarjetas(tarjetas.subList(i, i + 3));
            i++;

        }
    }

    private void repartirPaises(List<Pais> paises) {
        Collections.shuffle(paises);  //mezcla paises
        int cantidadPaises = 50;
        int cantidadCartas = cantidadPaises / cantidadTotalJugadores;
        int i = 0;
        for (Jugador jugador : this.jugadores) {
            List<Pais> paisesDeJugador = paises.subList(i, i + cantidadCartas);
            i += cantidadCartas;
            paisesDeJugador.forEach(pais -> pais.setJugador(jugador)); //agrego jugador como gobernante del pais
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
    }

    public List<Objetivo> getObjetivos(){
        return this.objetivos;
    }

    public Map<String, Object> toDTO(){
        Map<String, Object> dto = new HashMap<>();
        dto.put("Jugadores", this.jugadores);
        dto.put("Tablero", this.tablero);
        dto.put("CantJugadores", this.cantidadJugadoresActuales);
        return dto;
    }
}
