package algoteg.modelo;

import algoteg.Exceptions.AtaqueInvalidoException;
import algoteg.datosJuego.*;

import java.util.*;

public class Partida {

    private int cantidadTotalJugadores;
    private int cantidadJugadoresActuales;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    public Tablero tablero;
    private List<Objetivo> objetivos = new ArrayList<>();
    private LanzadorDados lanzadorDados = new LanzadorDados();
    private List<Turno> turnos = new ArrayList<>();
    private Integer indiceJugadorActual;
    private int turnoActual = 0;
    private List<Tarjeta> listaTarjetas;
    private Objetivo objetivoGeneral;




    public Partida(int cantidadTotalJugadores) {
        cantidadJugadoresActuales = 0;
        this.cantidadTotalJugadores = Math.min(cantidadTotalJugadores, 6);
        this.indiceJugadorActual = 0;





    }
    public void pasarTurno(){
        if(turnoActual ==3){
            turnoActual = 2;
        }
        else{
            turnoActual++;
        }
    }

    public void iniciarTurnoActual(Jugador jugador) {
        this.turnos.get(turnoActual).iniciarTurno(jugador);
    }

    public void pasarAJugadorSiguiente(){

        if(this.indiceJugadorActual == (cantidadJugadoresActuales-1)){
            this.indiceJugadorActual = 0;
            this.pasarTurno();
        }
        else {
            this.indiceJugadorActual++;
        }
        this.turnos.get(turnoActual).iniciarTurno(jugadores.get(indiceJugadorActual));
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
        return this.turnos.size();
    }

    public void inicializarJugadores(Integer cantdiadJugadores){
        
    }

    public void iniciarPartida() {
        List<Pais> paises = this.iniciarPaisesYContinentes();
        this.iniciarTarjetas(paises);

        inicializarObjetivos();
        for (Jugador jugador: jugadores){
            jugador.setContinentes(this.tablero.getContinentes());
        }
        turnos.add(new TurnoInicial(tablero, 5));
        turnos.add(new TurnoInicial(tablero, 3));
        turnos.add(new TurnoAtaque(tablero));
        turnos.add(new TurnoColocacion(tablero));

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
        this.listaTarjetas = tarjetas;

    }
    public Turno getTurnoActual(){return turnos.get(turnoActual);}
    public void colocar( int cantTropas, String pais){

        this.getTurnoActual().setJugador(this.getJugadorActual());
        this.getTurnoActual().colocar(cantTropas, this.getPaisPorNombre(pais));




    }


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
        this.objetivoGeneral = new ObjetivoGeneral(this.getJugadorActual());
    }

    private void repartirObjetivos(){
        Collections.shuffle(this.objetivos);
        int i = 0;
        for(Jugador jugador: jugadores){
            jugador.setObjetivo(this.objetivos.get(i));
            this.objetivos.get(i).setJugador(jugador);
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

    public void atacar(String paisAtacante, String paisDefensor, int numeroTropas) throws AtaqueInvalidoException {

        Pais ataca = this.getPaisPorNombre(paisAtacante);
        Pais defiende = this.getPaisPorNombre(paisDefensor);

        Pais paisGanador = turnos.get(turnoActual).atacar(ataca,defiende,numeroTropas);
        if (paisGanador == ataca) {
            this.getJugadorActual().addTarjeta(this.sacarTarjetaDelMazo());
        }

    }
    public Tarjeta sacarTarjetaDelMazo(){
        Tarjeta tarjeta = listaTarjetas.get(0);
        tarjeta.desactivar();
        listaTarjetas.remove(0);
        listaTarjetas.add(tarjeta);
        return tarjeta;
    }

    public void mover(Pais paisOrigen, Pais paisDestino, int numeroTropas) {

        turnos.get(turnoActual).moverEjercito(paisOrigen,paisDestino,numeroTropas);

    }


    public List<String> getOrdenJugadores() {
        List<String> ordenJugadores = new ArrayList<>();
        for (Jugador jugador: this.jugadores) {
            ordenJugadores.add(jugador.getColor());
        }
        return ordenJugadores;
    }

    public List<Objetivo> getObjetivosDeJugadores() {
        List<Objetivo> objetivos = new ArrayList<>();
        for (Jugador jugador: jugadores) {
            objetivos.add(jugador.getObjetivo());
        }
        return objetivos;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return this.jugadores;
    }

    public Pais getPaisPorNombre(String nombrePais) {
        List<Pais> listaPaises = this.tablero.getPaises();
        for (Pais pais: listaPaises) {
            if (pais.getNombre().equals(nombrePais)) { return pais; }
        }


        return null;
    }

    public boolean esTurnoDeColocacion() {
        return turnoActual == 3;
    }

    public boolean esTurnoDeAtaque() {
        return this.turnoActual == 2;
    }

    public boolean esTurnoInicial() { return this.turnoActual < 2;}


    public int obtenerTropasEnPais(String pais) {
        return this.getPaisPorNombre(pais).getEjercitoActual();

    }

    public int getIndiceJugadorActual() {return this.indiceJugadorActual;}

    public void activarTarjeta(String nombrePais) {
        Tarjeta tarjeta = this.getTarjetaPorNombre(nombrePais);
        this.getTurnoActual().activarTarjeta(tarjeta);
    }

    public void canjearTarjetas(String pais1, String pais2, String pais3){
        Tarjeta tarjeta1 = this.getTarjetaPorNombre(pais1);
        Tarjeta tarjeta2 = this.getTarjetaPorNombre(pais2);
        Tarjeta tarjeta3 = this.getTarjetaPorNombre(pais3);
        if(this.getTurnoActual().canjearTarjetas(tarjeta1, tarjeta2, tarjeta3)){

            tarjeta1.meterAlMazo();
            tarjeta2.meterAlMazo();
            tarjeta3.meterAlMazo();
        }
    }
    public List<Tarjeta> getListaTarjetas(){return this.listaTarjetas;
    }

    public Tarjeta getTarjetaPorNombre(String nombre) {
        String[] stringTarjeta = nombre.split(" ");

        String nombrePais = stringTarjeta[0];
        List<Tarjeta> listaTarjetas = this.getListaTarjetas();
        for (Tarjeta tarjeta: listaTarjetas) {
            if (tarjeta.getNombrePais().equals(nombrePais)) { return tarjeta; }
        }


        return null;
    }

    public boolean esPartidaGanada() {
        this.objetivoGeneral.setJugador(this.getJugadorActual());
        return this.objetivoGeneral.cumplido() || this.getJugadorActual().getObjetivo().cumplido();

    }


}
