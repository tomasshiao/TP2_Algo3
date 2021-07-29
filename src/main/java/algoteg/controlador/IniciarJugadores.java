package algoteg.controlador;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class IniciarJugadores {

    @FXML public Button aceptar;
    @FXML public TextField cantJugadores;

     @FXML public void handleEvent(ActionEvent event){   //lee el textfield y lo imprime por consola
         if(event.getSource().equals(aceptar) & !cantJugadores.getText().isEmpty()) {
          System.out.println(cantJugadores.getText());
         }

    }




}
