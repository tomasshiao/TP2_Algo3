package algoteg.controlador;

import algoteg.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import algoteg.modelo.*;

public class OrdenJugadores {
    private Juego juego;
    private FXML vista;
    @FXML
    public Label labelJugador1;
    @FXML
    public Label labelJugador2;
    @FXML
    public Label labelJugador3;
    @FXML
    public Label labelJugador4;
    @FXML
    public Label labelJugador5;
    @FXML
    public Label labelJugador6;
    @FXML
    public Circle jugador1;

    @FXML
    public Circle jugador2;
    @FXML
    public Circle jugador3;
    @FXML
    public Circle jugador4;
    @FXML
    public Circle jugador5;
    @FXML
    public Circle jugador6;

    private List<Circle> colores;
    private List<Label> labelsJugadores;


    public void controlador(Juego juego){
        this.juego = juego;
        this.vista = vista;

        colores = new ArrayList<>(List.of(jugador1,jugador2,jugador3,jugador4,jugador5,jugador6));
        labelsJugadores = new ArrayList<>(List.of(labelJugador1,labelJugador2,labelJugador3,labelJugador4,labelJugador5,labelJugador6));
        List<String> orden = juego.obtenerOrdenJugadores();

        for (int i = 0; i< juego.getCantidadJugadores(); i++){
            labelsJugadores.get(i).setVisible(true);
            colores.get(i).setFill(Color.web(orden.get(i)));

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
}
