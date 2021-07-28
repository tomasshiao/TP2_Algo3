package algoteg.controlador;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class VentanaInicial {



    @FXML
    public void salirPantallaPrincipal(Event event){
        try{
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/creacionJugadores.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1080,720);
            scene.setFill(Color.TRANSPARENT);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
