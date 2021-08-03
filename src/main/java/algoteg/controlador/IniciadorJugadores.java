package algoteg.controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import algoteg.modelo.*;

import java.io.IOException;

public class IniciadorJugadores {
    Juego juego;

    public void iniciador(Juego juego){
        this.juego = juego;
    }

    @FXML
    public void initialize(){
        toggleGroup = new ToggleGroup();
        op1.setToggleGroup(toggleGroup);
        op2.setToggleGroup(toggleGroup);
        op3.setToggleGroup(toggleGroup);
        op4.setToggleGroup(toggleGroup);
        op5.setToggleGroup(toggleGroup);

    }

    @FXML public Button aceptar;
    @FXML public Label cantJugadores;
    @FXML public RadioButton op1;
    @FXML public RadioButton op2;
    @FXML public RadioButton op3;
    @FXML public RadioButton op4;
    @FXML public RadioButton op5;
    private ToggleGroup toggleGroup;



    @FXML public void handleEvent(ActionEvent event){
        //lee el textfield y lo imprime por consola


        int jugadores = 0;
        if(event.getSource().equals(aceptar) & !cantJugadores.getText().isEmpty()) {
            try{
                jugadores = Integer.parseInt(cantJugadores.getText());
                this.juego.iniciarJuegoConJugadores(jugadores);

            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }

            this.cambiarScena(event);


        }

    }
    public void cambiarScena(ActionEvent event){
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;


            FXMLLoader loader = new FXMLLoader(getClass().getResource("/juego.fxml"));
            Parent root = loader.load();

            PantallaJuego pantalla = loader.getController();
            pantalla.pantalla(this.juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML public void actualizarLabel()
    {
        if(toggleGroup.getSelectedToggle().equals(this.op1)){
            this.cantJugadores.setText("2");

        }
        else if(toggleGroup.getSelectedToggle().equals(this.op2)){
            this.cantJugadores.setText("3");

        }
        else if(toggleGroup.getSelectedToggle().equals(this.op3)){
            this.cantJugadores.setText("4");

        }
        else if(toggleGroup.getSelectedToggle().equals(this.op4)){
            this.cantJugadores.setText("5");

        }
        else if(toggleGroup.getSelectedToggle().equals(this.op5)){
            this.cantJugadores.setText("6");

        }
    }
}
