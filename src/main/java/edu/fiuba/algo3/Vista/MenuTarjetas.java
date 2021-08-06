package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.controlador.TarjetasController;
import edu.fiuba.algo3.modelo.SistemaDeTurnos;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class MenuTarjetas {

    public static void display() throws IOException {
        URL url = new File("src/main/resources/vistas/Tarjetas.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Tarjetas");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

}
