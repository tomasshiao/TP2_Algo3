package algoteg.controlador;

import algoteg.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Controlador {
    private Juego juego;
    private FXML vista;
    AudioClip buzzer = new AudioClip(getClass().getResource("/sounds/algoTEG.mp3").toExternalForm());



    public void controlador(Juego juego){
        this.juego = juego;
        this.vista = vista;

    }

    @FXML
    public void salirPantallaPrincipal(ActionEvent event) {


        buzzer.play();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        proximaPantalla(event);
    }

    public void proximaPantalla(ActionEvent event){
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;


            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jugadores.fxml"));
            Parent root = loader.load();
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();
            IniciadorJugadores iniciadorJugadores = loader.getController();
            iniciadorJugadores.iniciador(this.juego);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


