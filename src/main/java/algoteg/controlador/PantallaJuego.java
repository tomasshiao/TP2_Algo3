package algoteg.controlador;

import algoteg.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PantallaJuego {
    Juego juego;


    @FXML
    public Label cantTropas;
    @FXML
    public Label cantJugadores;
    @FXML
    public Button prueba;
    @FXML
    public Button canada;
    @FXML
    public Button yukon;
    @FXML
    public Button terranova;
    @FXML
    public Button groenlandia;
    @FXML
    public Button alaska;
    @FXML
    public Button labrador;
    @FXML
    public Button mexico;
    @FXML
    public Button california;
    @FXML
    public Button oregon;
    @FXML
    public Button colombia;
    @FXML
    public Button chile;
    @FXML
    public Button uruguay;
    @FXML
    public Button peru;
    @FXML
    public Button argentina;
    @FXML
    public Button brasil;
    @FXML
    public Button nueva_york;
    @FXML
    public Button islandia;
    @FXML
    public Button alemania;
    @FXML
    public Button francia;
    @FXML
    public Button españa;
    @FXML
    public Button polonia;
    @FXML
    public Button suecia;
    @FXML
    public Button rusia;
    @FXML
    public Button italia;
    @FXML
    public Button israel;
    @FXML
    public Button turquia;
    @FXML
    public Button sudafrica;
    @FXML
    public Button madagascar;
    @FXML
    public Button egipto;
    @FXML
    public Button etiopia;
    @FXML
    public Button zaire;
    @FXML
    public Button sahara;
    @FXML
    public Button gobi;
    @FXML
    public Button iran;
    @FXML
    public Button mongolia;
    @FXML
    public Button china;
    @FXML
    public Button taymir;
    @FXML
    public Button siberia;
    @FXML
    public Button aral;
    @FXML
    public Button malasia;
    @FXML
    public Button india;
    @FXML
    public Button kamchatka;
    @FXML
    public Button arabia;
    @FXML
    public Button australia;
    @FXML
    public Button borneo;
    @FXML
    public Button sumatra;
    @FXML
    public Button japon;
    @FXML
    public Button tartaria;
    @FXML
    public Button java;







    public void mostrarTropasDisponibles() {
        this.cantTropas.setText("0");
    }

    public void mostrarCantJugadores(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(this.prueba)){
            this.cantJugadores.setText( Integer.toString(this.juego.getCantidadJugadores()));
        }
    }


    public void pantalla(Juego juego){
        this.juego  = juego;
    }


}
