package algoteg.controlador;

import algoteg.modelo.Continente;
import algoteg.modelo.Juego;
import algoteg.modelo.Jugador;
import algoteg.modelo.Pais;
import javafx.event.ActionEvent;
import algoteg.modelo.Tarjeta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.IOException;

public class PantallaJuego {
    Juego juego;

    @FXML
    public TextField tropasAColocar;
    @FXML
    public Label cantTropas;
    @FXML
    public Label cantJugadores;
    @FXML
    public ToggleButton gran_bretaña;
    @FXML
    public Button prueba;
    @FXML
    public ToggleButton canada;
    @FXML
    public ToggleButton yukon;
    @FXML
    public ToggleButton terranova;
    @FXML
    public ToggleButton groenlandia;
    @FXML
    public ToggleButton alaska;
    @FXML
    public ToggleButton labrador;
    @FXML
    public ToggleButton mexico;
    @FXML
    public ToggleButton california;
    @FXML
    public ToggleButton oregon;
    @FXML
    public ToggleButton colombia;
    @FXML
    public ToggleButton chile;
    @FXML
    public ToggleButton uruguay;
    @FXML
    public ToggleButton peru;
    @FXML
    public ToggleButton argentina;
    @FXML
    public ToggleButton brasil;
    @FXML
    public ToggleButton nueva_york;
    @FXML
    public ToggleButton islandia;
    @FXML
    public ToggleButton alemania;
    @FXML
    public ToggleButton francia;
    @FXML
    public ToggleButton españa;
    @FXML
    public ToggleButton polonia;
    @FXML
    public ToggleButton suecia;
    @FXML
    public ToggleButton rusia;
    @FXML
    public ToggleButton italia;
    @FXML
    public ToggleButton israel;
    @FXML
    public ToggleButton turquia;
    @FXML
    public ToggleButton sudafrica;
    @FXML
    public ToggleButton madagascar;
    @FXML
    public ToggleButton egipto;
    @FXML
    public ToggleButton etiopia;
    @FXML
    public ToggleButton zaire;
    @FXML
    public ToggleButton sahara;
    @FXML
    public ToggleButton gobi;
    @FXML
    public ToggleButton iran;
    @FXML
    public ToggleButton mongolia;
    @FXML
    public ToggleButton china;
    @FXML
    public ToggleButton taymir;
    @FXML
    public ToggleButton siberia;
    @FXML
    public ToggleButton aral;
    @FXML
    public ToggleButton malasia;
    @FXML
    public ToggleButton india;
    @FXML
    public ToggleButton kamchatka;
    @FXML
    public ToggleButton arabia;
    @FXML
    public ToggleButton australia;
    @FXML
    public ToggleButton borneo;
    @FXML
    public ToggleButton sumatra;
    @FXML
    public ToggleButton japon;
    @FXML
    public ToggleButton tartaria;
    @FXML
    public ToggleButton java;
    @FXML
    public Button colocar;
    @FXML
    public Button reagrupar;
    @FXML
    public Button atacar;
    @FXML
    public Button terminar;
    @FXML
    public Label tropasPais;
    @FXML
    public Label nombrePais;

    @FXML
    public Label advertencia;

    @FXML
    public Label tropasDisponiblesGlobal;
    @FXML
    public Label tropasDisponiblesAmericaDelSur;
    @FXML
    public Label tropasDisponiblesAmericaDelNorte;
    @FXML
    public Label tropasDisponiblesAfrica;
    @FXML
    public Label tropasDisponiblesEuropa;
    @FXML
    public Label tropasDisponiblesOceania;
    @FXML
    public Label tropasDisponiblesAsia;

    @FXML
    public Circle jugadorActual;
    @FXML
    public ChoiceBox paisDefensor;
    @FXML
    public ChoiceBox paisLlegada;
    @FXML
    public ChoiceBox paisSalida;
    @FXML
    public ChoiceBox paisAColocarTropas;
    @FXML
    public ChoiceBox paisAtacante;

    @FXML
    public Button obtenerPaisesDefensores;
    @FXML
    public Button obtenerPaisesLlegada;

    @FXML
    public ChoiceBox tarjeta1;
    @FXML
    public ChoiceBox tarjeta2;
    @FXML
    public ChoiceBox tarjeta3;

    @FXML
    public Button activarTarjeta;
    @FXML
    public Button canjearTarjetas;
    AudioClip buzzer = new AudioClip(getClass().getResource("/sounds/click.mp3").toExternalForm());


    Map<String, ToggleButton>  botones =  new HashMap<>();
    Map<ToggleButton, String>  botonesPaises =  new HashMap<>();
    List<Jugador> jugadores;
    Map<String,Pais> paises = new HashMap<>();
    String primerPaisSeleccionado;
    String segundoPaisSeleccionado;





    @FXML
    public void escribirLabels(ActionEvent event) {
        Object evento = event.getSource();
        Node nodo = (Node) evento;
        String id = nodo.getId();
        String pais = null;
        for (Map.Entry<ToggleButton, String> entry : botonesPaises.entrySet()) {
            if((entry.getKey()).getId().equals(id)){
                pais = entry.getValue();
            }
        }

        if(pais != null) {

            Pais paisActual = this.juego.getPaisPorNombre(pais);
            tropasPais.setText(Integer.toString(paisActual.getEjercitoActual()));
            nombrePais.setText(paisActual.getNombre());
        }



    }
    public void iniciarTurnoColocacion(){

        jugadorActual.setFill(Color.web(this.juego.getJugadorActual().getColor()));
        mostrarBotonesRondaColocacion();
        this.paisAColocarTropas.getItems().clear();
        List<Pais> paises = this.juego.getJugadorActual().getPaisesConquistados();

        for(Pais pais: paises){
            this.paisAColocarTropas.getItems().add(pais.getNombre());
        }
        this.paisAColocarTropas.getItems().sort(Comparator.naturalOrder());
        this.juego.iniciarTurnoActual(this.juego.getJugadorActual());
        this.completarChoicesTarjetas();
        escribirTropasDisponiblesColocacion();


    }

    public void escribirTropasDisponiblesColocacion() {
        tropasDisponiblesGlobal.setText(Integer.toString(this.juego.getTropasGlobales()));
        tropasDisponiblesAmericaDelSur.setText(this.juego.getTropasPorContinente("AmericaDelSur"));
        tropasDisponiblesAmericaDelNorte.setText(this.juego.getTropasPorContinente("AmericaDelNorte"));
        tropasDisponiblesEuropa.setText(this.juego.getTropasPorContinente("Europa"));
        tropasDisponiblesAsia.setText(this.juego.getTropasPorContinente("Asia"));
        tropasDisponiblesAfrica.setText(this.juego.getTropasPorContinente("Africa"));
        tropasDisponiblesOceania.setText(this.juego.getTropasPorContinente("Oceania"));

        
    }

//    public void escribirJugadorActual() {
//        jugadorActual.setText("Jugador " + juego.getIndiceJugadorActual());
//    }


    public void mostrarTropasDisponibles() {
        this.cantTropas.setText("0");
    }

    public void mostrarCantJugadores(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(this.prueba)){
            this.cantJugadores.setText( Integer.toString(this.juego.getCantidadJugadores()));
        }
    }


    public void pantalla(Juego juego) {

        this.juego = juego;
        this.inicializarPaises();
        this.jugadores = juego.getListaJugadores();
        this.inicializarColoresDePaises();
        this.mostrarBotonesRondaColocacion();
        this.inicializarBotoesPais();
        this.iniciarTurnoColocacion();


    }

    public void mostrarBotonesRondaColocacion() {
        this.colocar.setVisible(true);
        this.colocar.setDisable(false);

        this.reagrupar.setDisable(true);
        this.reagrupar.setVisible(false);

        this.atacar.setDisable(true);
        this.atacar.setVisible(false);

        this.terminar.setDisable(true);
        this.terminar.setVisible(false);

        this.paisAColocarTropas.setVisible(true);
        this.paisAColocarTropas.setDisable(false);

        this.paisLlegada.setVisible(false);
        this.paisLlegada.setDisable(true);

        this.paisSalida.setVisible(false);
        this.paisSalida.setDisable(true);

        this.paisAtacante.setVisible(false);
        this.paisAtacante.setDisable(true);

        this.paisDefensor.setVisible(false);
        this.paisDefensor.setDisable(true);

        this.obtenerPaisesDefensores.setVisible(false);
        this.obtenerPaisesDefensores.setDisable(true);

        this.obtenerPaisesLlegada.setVisible(false);
        this.obtenerPaisesLlegada.setDisable(true);

        this.tarjeta1.setVisible(true);
        this.tarjeta1.setDisable(false);

        this.tarjeta2.setVisible(true);
        this.tarjeta2.setDisable(false);

        this.tarjeta3.setVisible(true);
        this.tarjeta3.setDisable(false);

        this.activarTarjeta.setVisible(true);
        this.activarTarjeta.setDisable(false);

        this.canjearTarjetas.setDisable(false);
        this.canjearTarjetas.setVisible(true);



        escribirTropasDisponiblesColocacion();





    }

    public void mostrarBotonesRondaAtaque() {
        this.colocar.setDisable(true);
        this.colocar.setVisible(false);

        this.reagrupar.setDisable(false);
        this.reagrupar.setVisible(true);

        this.atacar.setDisable(false);
        this.atacar.setVisible(true);

        this.paisAColocarTropas.setVisible(false);
        this.paisAColocarTropas.setDisable(true);

        this.paisLlegada.setVisible(true);
        this.paisLlegada.setDisable(false);

        this.paisSalida.setVisible(true);
        this.paisSalida.setDisable(false);

        this.paisAtacante.setVisible(true);
        this.paisAtacante.setDisable(false);

        this.paisDefensor.setVisible(true);
        this.paisDefensor.setDisable(false);

        this.obtenerPaisesDefensores.setVisible(true);
        this.obtenerPaisesDefensores.setDisable(false);

        this.obtenerPaisesLlegada.setVisible(true);
        this.obtenerPaisesLlegada.setDisable(false);

        this.tarjeta1.setVisible(false);
        this.tarjeta1.setDisable(true);

        this.tarjeta2.setVisible(false);
        this.tarjeta2.setDisable(true);

        this.tarjeta3.setVisible(false);
        this.tarjeta3.setDisable(true);

        this.canjearTarjetas.setVisible(false);
        this.canjearTarjetas.setDisable(true);
        this.activarTarjeta.setVisible(false);
        this.activarTarjeta.setDisable(true);
    }


    @FXML
    public void terminar() {
        buzzer.play();
        this.juego.pasarAJugadorSiguiente();
        System.out.println(this.juego.getIndiceJugadorActual());
        if(this.juego.esTurnoDeColocacion()){
            this.iniciarTurnoColocacion();
        }
        if(this.juego.esTurnoDeAtaque()){
            iniciarTurnoAtaque();
        }
        if (this.juego.esTurnoInicial()){
            this.iniciarTurnoColocacion();
        }



    }

    private void inicializarColoresDePaises(){
        for (Jugador jugador : jugadores
        ) {
            List<Pais> paisesJugador = jugador.getPaisesConquistados();
            for (Pais paisConquistado : paisesJugador) {
                String colorJugador = jugador.getColor();

                Color fondo = Color.web(colorJugador);
                String nombrePais = paisConquistado.getNombre();
                ToggleButton botonPais = botones.get(nombrePais);
                botonPais.setStyle("-fx-background-color: " + colorJugador + ";");

            }
        }
    }



    private void inicializarPaises(){
        botones.put("Canada",canada);
        botones.put("Yukon",yukon );
        botones.put("Terranova", terranova);
        botones.put("Groenlandia", groenlandia);
        botones.put("Alaska", alaska);
        botones.put("Labrador", labrador);
        botones.put("Mexico", mexico);
        botones.put("California", california);
        botones.put("Oregon", oregon);
        botones.put("Colombia", colombia);
        botones.put("Chile", chile);
        botones.put("Uruguay", uruguay);
        botones.put("Peru", peru);
        botones.put("Argentina", argentina);
        botones.put("Brasil", brasil);
        botones.put("Nueva York", nueva_york);
        botones.put("Islandia", islandia);
        botones.put("Alemania", alemania);
        botones.put("Francia", francia);
        botones.put("Espana", españa);
        botones.put("Polonia", polonia);
        botones.put("Suecia", suecia);
        botones.put("Rusia", rusia);
        botones.put("Italia", italia);
        botones.put("Israel", israel);
        botones.put("Turquia", turquia);
        botones.put("Sudafrica", sudafrica);
        botones.put("Madagascar", madagascar);
        botones.put("Egipto", egipto);
        botones.put("Etiopia", etiopia);
        botones.put("Zaire", zaire);
        botones.put("Sahara", sahara);
        botones.put("Gobi", gobi);
        botones.put("Iran", iran);
        botones.put("Mongolia", mongolia);
        botones.put("China", china);
        botones.put("Taimir", taymir);
        botones.put("Siberia", siberia);
        botones.put("Aral", aral);
        botones.put("Malasia", malasia);
        botones.put("India", india);
        botones.put("Kamchatka", kamchatka);
        botones.put("Arabia", arabia);
        botones.put("Australia", australia);
        botones.put("Borneo", borneo);
        botones.put("Sumatra", sumatra);
        botones.put("Japon", japon);
        botones.put("Tartaria", tartaria);
        botones.put("Gran Bretana", gran_bretaña);
        botones.put("Java", java);
    }

    private void inicializarBotoesPais(){
        for(String s : botones.keySet()){
            botonesPaises.put(botones.get(s), s);
        }
    }


    public void iniciarTurnoAtaque(){

        jugadorActual.setFill(Color.web(this.juego.getJugadorActual().getColor()));
        mostrarBotonesRondaAtaque();
        this.paisAtacante.getItems().clear();
        this.paisSalida.getItems().clear();
        this.paisLlegada.getItems().clear();
        this.paisDefensor.getItems().clear();
        List<Pais> paises = this.juego.getJugadorActual().getPaisesConquistados();

        for(Pais pais: paises){
            this.paisAtacante.getItems().add(pais.getNombre());
            this.paisSalida.getItems().add(pais.getNombre());

        }
        this.juego.iniciarTurnoActual(this.juego.getJugadorActual());
        escribirTropasDisponiblesColocacion();

    }

    @FXML
    public void setObtenerPaisesDefensores(ActionEvent event) {

        Object evento = event.getSource();
        Node eventoSource = (Node) evento;
        String id = eventoSource.getId();
        if(evento.equals(obtenerPaisesDefensores) && paisAtacante.getValue() != null){
            buzzer.play();
            Pais paisAtaca = this.juego.getPaisPorNombre(paisAtacante.getValue().toString());
            List<Pais> limitrofes = paisAtaca.getPaisesLimitrofes();
            paisDefensor.getItems().clear();
            for(Pais pais: limitrofes){
                if(!pais.esGobernadoPor(this.juego.getJugadorActual())){
                    paisDefensor.getItems().add(pais.getNombre());
                }
            }
            paisDefensor.getItems().sort(Comparator.naturalOrder());


        }
    }


    @FXML
    public void setObtenerPaisesLlegada(ActionEvent event) {
        Object evento = event.getSource();
        Node eventoSource = (Node) evento;
        String id = eventoSource.getId();
        if(evento.equals(obtenerPaisesLlegada) )
            if(paisSalida.getValue() != null){
                Pais paisSale = this.juego.getPaisPorNombre(paisSalida.getValue().toString());
                List<Pais> limitrofes = paisSale.getPaisesLimitrofes();
                paisLlegada.getItems().clear();
                for (Pais pais : limitrofes) {
                    if (pais.esGobernadoPor(this.juego.getJugadorActual())) {
                        paisLlegada.getItems().add(pais.getNombre());
                }
            }
                paisLlegada.getItems().sort(Comparator.naturalOrder());

        }
    }



    @FXML
    public void colocar(ActionEvent  event ){
        if(event.getSource().equals(colocar) && !tropasAColocar.getText().isEmpty() && this.paisAColocarTropas.getValue() != null ){
            try{
                int tropas = Integer.parseInt(tropasAColocar.getText());
                juego.colocar(tropas, this.paisAColocarTropas.getValue().toString());
                System.out.println(this.paisAColocarTropas.getValue().toString());

            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }
        }

        if(this.juego.getJugadorActual().getEjercitoParaIncorporar() == 0) {
            terminar.setVisible(true);
            terminar.setDisable(false);
        }

        escribirTropasDisponiblesColocacion();


    }

    @FXML
    public void atacar(ActionEvent event) {
        if(event.getSource().equals(atacar) && !tropasAColocar.getText().isEmpty()  && this.paisAtacante.getValue() != null && this.paisDefensor.getValue() != null ) {
            int tropas = Integer.parseInt(tropasAColocar.getText());
            try{
                juego.atacar(this.paisAtacante.getValue().toString(), this.paisDefensor.getValue().toString(), tropas);
                if(this.juego.getPaisPorNombre(paisDefensor.getValue().toString()).esGobernadoPor(this.juego.getJugadorActual())){
                    botones.get(paisDefensor.getValue().toString()).setStyle("-fx-background-color: "+this.juego.getJugadorActual().getColor() + ";");
                    this.completarChoicesTarjetas();
                    paisSalida.getItems().clear();
                    paisAtacante.getItems().clear();
                    List<Pais> paises = this.juego.getJugadorActual().getPaisesConquistados();

                    for(Pais pais: paises){
                        this.paisAtacante.getItems().add(pais.getNombre());
                        this.paisSalida.getItems().add(pais.getNombre());

                    }
                    paisAtacante.getItems().sort(Comparator.naturalOrder());
                    paisSalida.getItems().sort(Comparator.naturalOrder());
                }

                if(this.juego.esPartidaGanada()){
                    this.cambiarScena(event, this.juego.getJugadorActual().getColor());
                }


            }
            catch (Exception e){
                advertencia.setText("Ataque invalido.");
                try{Thread.sleep(3000);}
                catch (InterruptedException excp){excp.printStackTrace();}
                advertencia.setText("");
                e.printStackTrace();
            }
        }


    }



    @FXML
    public void reagrupar(ActionEvent event){
        if(event.getSource().equals(reagrupar) && !tropasAColocar.getText().isEmpty() && this.paisLlegada.getValue() != null && this.paisSalida.getValue() != null){

            this.juego.reagrupar(this.paisSalida.getValue().toString(), this.paisLlegada.getValue().toString(), Integer.parseInt(tropasAColocar.getText()));
        }
    }

    @FXML
    public void activarTarjeta(ActionEvent event) {
        if (event.getSource().equals(activarTarjeta) && tarjeta1.getValue() != null && tarjeta2.getValue() == null && tarjeta3.getValue() == null){
            this.juego.activarTarjeta(tarjeta1.getValue().toString());
            escribirTropasDisponiblesColocacion();
        }
    }

    @FXML
    public void canjearTarjetas(ActionEvent event) {
        if (event.getSource().equals(activarTarjeta) && tarjeta1.getValue() != null && tarjeta2.getValue() != null && tarjeta3.getValue() != null){
            this.juego.canjearTarjetas(tarjeta1.getValue().toString(), tarjeta2.getValue().toString(), tarjeta3.getValue().toString());
            escribirTropasDisponiblesColocacion();
        }
    }

    @FXML
    public void completarChoicesTarjetas() {
        tarjeta1.getItems().clear();
        tarjeta2.getItems().clear();
        tarjeta3.getItems().clear();

        Jugador jugadorActual = this.juego.getJugadorActual();
        List<Tarjeta> listaTarjetasJugador = jugadorActual.getTarjetas();
        for(Tarjeta tarjeta: listaTarjetasJugador) {
            tarjeta1.getItems().add(tarjeta.getNombrePais()+" " +tarjeta.getDibujo());
            tarjeta2.getItems().add(tarjeta.getNombrePais()+" " +tarjeta.getDibujo());
            tarjeta3.getItems().add(tarjeta.getNombrePais() +" " + tarjeta.getDibujo());
        }



    }

    public void cambiarScena(ActionEvent event, String color) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;


            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ganador.fxml"));
            Parent root = loader.load();

            Ganador pantalla = loader.getController();
            pantalla.controlador(color);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
