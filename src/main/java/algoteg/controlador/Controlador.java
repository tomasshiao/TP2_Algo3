package algoteg.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controlador {

    @FXML
    private void atacar (ActionEvent event) {
        event.consume();
        System.out.println("Atacar!!!!");
    }

}
