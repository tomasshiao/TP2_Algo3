package algoteg.controlador;

import algoteg.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Objetivos {
    @FXML
    public Button obtenerObjetivo;
    @FXML
    public Label objetivo;
    Juego juego;

    public void iniciarObjetivos(Juego juego){
        this.juego = juego;
    }

    @FXML
    public void obtenerObjetivo(ActionEvent event){


    }
}
