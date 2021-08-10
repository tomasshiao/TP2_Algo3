package algoteg.controlador;

import algoteg.modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.*;

public class ControladorObjetivos {
    @FXML
    public Button obtenerObjetivo;
    @FXML
    public Label objetivo;
    @FXML
    public Label labelJugador;
    @FXML
    public Label objetivoSecreto;
    @FXML
    public Circle colorJugador;
    @FXML
    public AnchorPane contenedor;
    @FXML
    public VBox contenedorVBox;
    AudioClip buzzer = new AudioClip(getClass().getResource("/sounds/click.mp3").toExternalForm());

    Juego juego;
    ArrayList<Jugador> jugadores;
    int jugadorActual = 0;

    public void pantalla(Juego juego){
        this.juego = juego;
        this.jugadores = juego.getListaJugadores();
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


    public static List<Integer> hex2Rgb(String colorStr) {
        return Arrays.asList(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
    }

    public static String rgb2Hex(List<Integer> listaRGB){
        Integer r = listaRGB.get(0);
        Integer g = listaRGB.get(1);
        Integer b = listaRGB.get(2);
        return String.format("#%02x%02x%02x", r, g, b);
    }

    public static List<Integer> getContrastingColor(List<Integer> colorRGB){
        Integer r = colorRGB.get(0);
        Integer g = colorRGB.get(1);
        Integer b = colorRGB.get(2);
        int rNueva = r > 0 ? 256 - r : 255;
        int gNueva = g > 0 ? 256 - g : 255;
        int bNueva = b > 0 ? 256 - b : 255;
        return  Arrays.asList(rNueva, gNueva, bNueva);
    }

    public static String encontrarColorAltoContraste(String color){
        List<Integer> colorRGB = hex2Rgb(color);
        List<Integer> colorContrasteRGB = getContrastingColor(colorRGB);
        return rgb2Hex(colorContrasteRGB);
    }


    @FXML
    public void obtenerObjetivo(ActionEvent event){
        buzzer.play();
        if(jugadorActual == juego.getCantidadJugadores()) {
            this.cambiarScena(event);
        }
        else {
            if(jugadorActual == 0){
                obtenerObjetivo.setText("Objetivo siguiente jugador");
            }
            labelJugador.setVisible(true);
            String color = jugadores.get(jugadorActual).getColor();
            String colorContraste = encontrarColorAltoContraste(color);
            objetivo.setText(jugadores.get(jugadorActual).getObjetivo().getMensajeObjetivo());
            objetivo.setTextFill(Color.web(color));
            contenedor.setStyle("-fx-background-color: " + colorContraste);
            contenedorVBox.setStyle("-fx-background-color: " + colorContraste);
            colorJugador.setFill(Color.web(color));
            labelJugador.setTextFill(Color.web(color));
            objetivoSecreto.setTextFill(Color.web(color));
            labelJugador.setText("Jugador " + (jugadorActual + 1));
            jugadorActual++;
            if (jugadorActual == juego.getCantidadJugadores()) {
                obtenerObjetivo.setText("Comenzar Partida");
            }
        }
    }
}
