package algoteg.controlador;

import algoteg.modelo.Juego;
import algoteg.modelo.Objetivo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;

public class ControladorObjetivos {
    @FXML
    public Button obtenerObjetivo;
    @FXML
    public Label objetivo;
    Juego juego;
    ArrayList<Jugador> jugadores;
    int jugadorActual = 0;

    public void pantalla(Juego juego){
        this.juego = juego;
        this.jugadores = juego.getListaJugadores();
    }

    @FXML
    public void obtenerObjetivo(ActionEvent event){
        objetivo.setText(objetivos.get(objetivoActual).getMensajeObjetivo());
        objetivoActual++;


    }
}
