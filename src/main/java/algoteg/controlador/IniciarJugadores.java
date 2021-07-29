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
         int jugadores = 0;
         if(event.getSource().equals(aceptar) & !cantJugadores.getText().isEmpty()) {
             try{
                 jugadores = Integer.parseInt(cantJugadores.getText());
             }
             catch (NumberFormatException e){
                 e.printStackTrace();
             }

             if(jugadores>=2 & jugadores<=6) {
                 System.out.println(jugadores);
             }
         }

    }



}
