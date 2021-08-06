package algoteg.modelo;

import algoteg.controlador.Controlador;
import algoteg.controlador.IniciadorJugadores;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Juego juego = new Juego();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        Parent root = loader.load();
        Controlador controlador = loader.getController();
        controlador.controlador(juego);
        Scene scene = new Scene(root, 500,500);
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("AlgoTEG G18");

        stage.setMinWidth(1080);
        stage.setMinHeight(720);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {


        Juego juego = new Juego();


        launch();

    }
}
