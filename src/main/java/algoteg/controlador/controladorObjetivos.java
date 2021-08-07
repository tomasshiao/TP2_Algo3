package algoteg.controlador;

import algoteg.modelo.Juego;
import algoteg.modelo.Objetivo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;

public class controladorObjetivos {
    @FXML
    public Button obtenerObjetivo;
    @FXML
    public Label objetivo;
    Juego juego;
    List<Objetivo> objetivos;
    int objetivoActual = 0;

    public void iniciarObjetivos(Juego juego){
        this.juego = juego;
        objetivos  = juego.obtenerObjetivos();
    }

    @FXML
    public void obtenerObjetivo(ActionEvent event){
        objetivo.setText(objetivos.get(objetivoActual).getMensajeObjetivo());
        objetivoActual++;


    }
}
