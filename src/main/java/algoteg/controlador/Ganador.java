package algoteg.controlador;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ganador {
    @FXML
    public Circle jugador;

    public void controlador(String color){
        jugador.setFill(Color.web(color));
    }
}
