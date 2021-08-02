package algoteg.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PantallaJuego {


    @FXML
    public Label cantTropas;

    public void mostrarTropasDisponibles() {
        this.cantTropas.setText("0");
    }
}
