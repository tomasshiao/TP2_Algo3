package algoteg.vista;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.net.URL;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception{
       // FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(new URL("file:///D:\\DOCUMENTOS\\FACULTAD\\ALGO3\\TP2_Algo3_TEG\\src\\main\\java\\algoteg\\vista\\main.fxml"));
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/main.fxml"));
        // AnchorPane anchorPane = loader.<AnchorPane>load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("AlgoTEG Grupo18");
        stage.show();
    }
    public static void main(String[] args){
        launch();
    }

}
